package crest.jira.data.retriever;

import crest.jira.data.retriever.map.CustomFieldMapper;
import crest.jira.data.retriever.map.IssueMapper;
import crest.jira.data.retriever.map.IssueWithCustomFields;
import crest.jira.data.retriever.model.CustomFieldsCatalog;
import crest.jira.data.retriever.model.Field;
import crest.jira.data.retriever.model.Issue;

import java.text.ParseException;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class IssueRetriever extends BaseRetriever {

  private static final String EXPAND_PARAM = "expand";
  private static final String ISSUE_PATH = "/rest/agile/latest/issue/{issueIdOrKey}";
  private IssueMapper issueMapper;
  private CustomFieldMapper customFieldMapper;

  /**
   * Retriever configuration.
   * 
   * @param client
   *          Client instance.
   * @param configuration
   *          Configuration instance.
   * @param fields
   *          Field catalog.
   */
  public IssueRetriever(Client client, JiraApiConfiguration configuration, Field[] fields) {
    super(client, configuration);
    this.issueMapper = new IssueMapper();
    this.customFieldMapper = new CustomFieldMapper(fields);
  }

  /**
   * Returns issue information.
   * 
   * @param issueIdOrKey
   *          Issue identifier.
   * @return Issue instance.
   * @throws ParseException
   *           In case of Date parsing problems.
   */
  @SuppressWarnings("rawtypes")
  public IssueWithCustomFields getIssue(String issueIdOrKey, String... expand)
      throws ParseException {
    String uri = getConfiguration().getHostAndContext() + ISSUE_PATH;

    WebTarget target = getClient().target(uri).resolveTemplate("issueIdOrKey", issueIdOrKey);

    if (expand != null && expand.length > 0) {
      target = addExpandSupport(target, expand);
    }

    Map issueAsMap = getBuilder(target).get(Map.class);

    Issue issue = issueMapper.map(issueAsMap);
    CustomFieldsCatalog customFields = customFieldMapper.map(issueAsMap);

    return new IssueWithCustomFields(issue, customFields);
  }

  private WebTarget addExpandSupport(WebTarget target, String... expand) {
    String expandValue = "";
    for (String expandItem : expand) {
      expandValue += expandItem + ",";
    }

    String queryParamValue = expandValue.substring(0, expandValue.length() - 1);

    target = target.queryParam(EXPAND_PARAM, queryParamValue);
    return target;
  }
}

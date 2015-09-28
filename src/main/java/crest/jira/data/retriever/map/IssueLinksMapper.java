package crest.jira.data.retriever.map;

import crest.jira.data.retriever.model.Field;
import crest.jira.data.retriever.model.IssueLink;
import crest.jira.data.retriever.model.IssueLinkType;

import org.codehaus.jackson.map.ObjectMapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IssueLinksMapper {

  private ObjectMapper objectMapper;
  private IssueMapper issueMapper;

  /**
   * Initializes instance attributes.
   */
  public IssueLinksMapper(Field[] fields) {
    objectMapper = new ObjectMapper();
    issueMapper = new IssueMapper(fields);

  }

  /**
   * Generates an IssueLink array based on a JSON Representation.
   * 
   * @param list
   *          JSON representing the list.
   * @return Array of IssueLink instances.
   * @throws ParseException
   *           In case of Date parsing issues.
   */
  @SuppressWarnings("rawtypes")
  public IssueLink[] map(ArrayList<Map<String, Object>> list) throws ParseException {

    List<IssueLink> responseAsList = new ArrayList<IssueLink>();

    for (Map<String, Object> issueLinkMap : list) {
      IssueLink issueLink = new IssueLink();
      issueLink.setId((String) issueLinkMap.get("id"));
      issueLink.setSelf((String) issueLinkMap.get("self"));
      issueLink.setType(objectMapper.convertValue(issueLinkMap.get("type"), IssueLinkType.class));

      Object outwardMap = issueLinkMap.get("outwardIssue");
      if (outwardMap != null) {
        issueLink.setOutwardIssue(issueMapper.map((Map) outwardMap));
      }

      Object inwardMap = issueLinkMap.get("inwardIssue");
      if (inwardMap != null) {
        issueLink.setInwardIssue(issueMapper.map((Map) inwardMap));
      }

      responseAsList.add(issueLink);
    }

    return responseAsList.toArray(new IssueLink[responseAsList.size()]);
  }

}

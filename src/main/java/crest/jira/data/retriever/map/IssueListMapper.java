package crest.jira.data.retriever.map;

import crest.jira.data.retriever.model.CustomFieldsCatalog;
import crest.jira.data.retriever.model.Field;
import crest.jira.data.retriever.model.Issue;

import java.text.ParseException;
import java.util.Map;

public class IssueListMapper extends ResponseListMapper<IssueWithCustomFields> {

  private IssueMapper issueMapper;
  private CustomFieldMapper customFieldMapper;

  /**
   * Initialized the mapper.
   * 
   * @param fields
   *          Custom field catalog.
   */
  public IssueListMapper(Field[] fields) {
    super("issues", IssueWithCustomFields.class);
    this.issueMapper = new IssueMapper();
    this.customFieldMapper = new CustomFieldMapper(fields);
  }

  @Override
  protected IssueWithCustomFields getItem(Map<String, Object> issueMap) throws ParseException {
    Issue issue = issueMapper.map(issueMap);
    CustomFieldsCatalog customFields = customFieldMapper.map(issueMap);

    return new IssueWithCustomFields(issue, customFields);
  }

}

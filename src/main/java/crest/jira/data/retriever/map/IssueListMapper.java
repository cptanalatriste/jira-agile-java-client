package crest.jira.data.retriever.map;

import crest.jira.data.retriever.model.Field;
import crest.jira.data.retriever.model.Issue;

import java.text.ParseException;
import java.util.Map;

public class IssueListMapper extends ResponseListMapper<Issue> {

  private IssueMapper issueMapper;

  public IssueListMapper(Field[] fields) {
    super("issues", Issue.class);
    this.issueMapper = new IssueMapper(fields);
  }

  @Override
  protected Issue getItem(Map<String, Object> issueMap) throws ParseException {
    Issue issue = issueMapper.map(issueMap);
    return issue;
  }

}

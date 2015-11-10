package crest.jira.data.retriever.model;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "FixVersionPerIssue")
public class FixVersionPerIssue extends AbstractVersionPerIssue {

  public FixVersionPerIssue() {
    super(null, null);
  }

  public FixVersionPerIssue(Issue issue, Version version) {
    super(issue, version);
  }

}

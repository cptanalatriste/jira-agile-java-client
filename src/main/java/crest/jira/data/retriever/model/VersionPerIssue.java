package crest.jira.data.retriever.model;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "VersionPerIssue")
public class VersionPerIssue extends AbstractVersionPerIssue {

  public VersionPerIssue() {
    super(null, null);
  }

  public VersionPerIssue(Issue issue, Version version) {
    super(issue, version);
  }

}

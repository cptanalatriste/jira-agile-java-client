package crest.jira.data.retriever.model;

import com.j256.ormlite.table.DatabaseTable;

/**
 * Project version(s) for which the issue is (or was) manifesting.
 * 
 * @see <a href=
 *      "https://confluence.atlassian.com/jira/what-is-an-issue-270829373.html">
 *      What is an Issue, from JIRA User's Guide </a>
 * 
 * @author Carlos G. Gavidia
 */
@DatabaseTable(tableName = "VersionPerIssue")
public class VersionPerIssue extends AbstractVersionPerIssue {

  public VersionPerIssue() {
    super(null, null);
  }

  public VersionPerIssue(Issue issue, Version version) {
    super(issue, version);
  }

}

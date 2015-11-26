package crest.jira.data.retriever.model;

import com.j256.ormlite.table.DatabaseTable;

/**
 * Project version(s) in which the issue was (or will be) fixed.
 * 
 * @see <a href=
 *      "https://confluence.atlassian.com/jira/what-is-an-issue-270829373.html">
 *      What is an Issue, from JIRA User's Guide </a>
 * 
 * @author Carlos G. Gavidia
 */
@DatabaseTable(tableName = "FixVersionPerIssue")
public class FixVersionPerIssue extends AbstractVersionPerIssue {

  public FixVersionPerIssue() {
    super(null, null);
  }

  public FixVersionPerIssue(Issue issue, Version version) {
    super(issue, version);
  }

}

package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Each issue has a status, which indicates where the issue currently is in its
 * lifecycle ('workflow'). An issue starts as being 'Open', then generally
 * progresses to 'Resolved' and then 'Closed'; or, depending on circumstances,
 * it may progress to other statuses.
 * 
 * <li>Open — This issue is in the initial 'Open' state, ready for the assignee
 * to start work on it.
 * <li>In Progress — This issue is being actively worked on at the moment by the
 * assignee.
 * <li>Resolved — A Resolution has been identified or implemented, and this
 * issue is awaiting verification by the reporter. From here, issues are either
 * 'Reopened' or are 'Closed'.
 * <li>Reopened — This issue was once 'Resolved' or 'Closed', but is now being
 * re-examined. From here, issues are either marked In Progress, Resolved or
 * Closed.
 * <li>Closed — This issue is complete.
 * 
 * @see <a href=
 *      "https://confluence.atlassian.com/jira/what-is-an-issue-270829373.html">
 *      What is an Issue, from JIRA User's Guide </a>
 * 
 * @author Carlos G. Gavidia
 *
 */
@DatabaseTable(tableName = "Status")
public class Status extends JiraEntity {

  @DatabaseField
  private String iconUrl;
  @DatabaseField(foreign = true, columnName = "statusCategoryId")
  private StatusCategory statusCategory;

  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  public StatusCategory getStatusCategory() {
    return statusCategory;
  }

  public void setStatusCategory(StatusCategory statusCategory) {
    this.statusCategory = statusCategory;
  }
}

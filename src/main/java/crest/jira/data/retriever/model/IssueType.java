package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * JIRA can be used to track many different types of issues. The default types are:
 * 
 * <li> Bug — A problem which impairs or prevents the functions of the product.
 * <li> Improvement — An enhancement to an existing feature.
 * <li> New Feature — A new feature of the product.
 * <li> Task — A task that needs to be done.
 * <li> Custom Issue — A custom issue type, as defined by your organization if required.
 * 
 * @see
 *  <a href="https://confluence.atlassian.com/jira/what-is-an-issue-270829373.html">
 *    What is an Issue, from JIRA User's Guide
 *  </a>
 * 
 * @author Carlos G. Gavidia
 *
 */
@DatabaseTable(tableName = "IssueType")
public class IssueType extends JiraEntity {

  @DatabaseField
  private String iconUrl;
  @DatabaseField
  private boolean subtask;

  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  public boolean getSubtask() {
    return subtask;
  }

  public void setSubtask(boolean subtask) {
    this.subtask = subtask;
  }

}

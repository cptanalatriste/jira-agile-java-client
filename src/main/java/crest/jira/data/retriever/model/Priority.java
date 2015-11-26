package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * An issue's priority indicates its relative importance.
 * 
 * <li>Blocker — Highest priority. Indicates that this issue takes precedence
 * over all others.
 * <li>Critical — Indicates that this issue is causing a problem and requires
 * urgent attention.
 * <li>Major — Indicates that this issue has a significant impact.
 * <li>Minor — Indicates that this issue has a relatively minor impact.
 * <li>Trivial — Lowest priority.
 * 
 * @see <a href=
 *      "https://confluence.atlassian.com/jira/what-is-an-issue-270829373.html">
 *      What is an Issue, from JIRA User's Guide </a>
 * 
 * @author Carlos G. Gavidia
 */
@DatabaseTable(tableName = "Priority")
public class Priority extends JiraEntity {

  @DatabaseField
  private String iconUrl;

  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

}

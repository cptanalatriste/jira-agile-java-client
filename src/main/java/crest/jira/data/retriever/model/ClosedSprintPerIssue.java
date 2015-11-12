package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ClosedSprintPerIssue")
public class ClosedSprintPerIssue extends BoardRelatedEntity {

  @DatabaseField(foreign = true, columnName = "issueId")
  private Issue issue;
  @DatabaseField(foreign = true, columnName = "sprintId")
  private Sprint sprint;

  public ClosedSprintPerIssue() {
    super(null);
  }

  /**
   * Relates an Issue with a closed sprint.
   * 
   * @param issue
   *          The issue.
   * @param sprint
   *          The closed sprint.
   */
  public ClosedSprintPerIssue(Issue issue, Sprint sprint) {
    super(issue.getBoardId());
    this.issue = issue;
    this.sprint = sprint;
  }

  public Issue getIssue() {
    return issue;
  }

  public void setIssue(Issue issue) {
    this.issue = issue;
  }

  public Sprint getSprint() {
    return sprint;
  }

  public void setSprint(Sprint sprint) {
    this.sprint = sprint;
  }

}

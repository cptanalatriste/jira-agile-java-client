package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ClosedSprintPerIssue")
public class ClosedSprintPerIssue {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField(foreign = true, columnName = "issueId")
  private Issue issue;
  @DatabaseField(foreign = true, columnName = "sprintId")
  private Sprint sprint;

  public ClosedSprintPerIssue() {

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
    super();
    this.issue = issue;
    this.sprint = sprint;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SubtaskPerIssue")
public class SubtaskPerIssue extends BoardRelatedEntity {

  @DatabaseField(foreign = true, columnName = "issueId")
  private Issue issue;
  @DatabaseField(foreign = true, columnName = "subtaskId")
  private Issue subtask;

  public SubtaskPerIssue() {
    super(null);
  }

  /**
   * Assigns an Issue as a Subtask of another issue.
   * 
   * @param issue
   *          Original issue.
   * @param subtask
   *          Subtask.
   */
  public SubtaskPerIssue(Issue issue, Issue subtask) {
    super(issue.getBoardId());
    this.issue = issue;
    this.subtask = subtask;
  }

  public Issue getIssue() {
    return issue;
  }

  public void setIssue(Issue issue) {
    this.issue = issue;
  }

  public Issue getSubtask() {
    return subtask;
  }

  public void setSubtask(Issue subtask) {
    this.subtask = subtask;
  }

}

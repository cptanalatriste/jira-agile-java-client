package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "IssueLink")
public class IssueLink extends JiraEntity {

  @DatabaseField(foreign = true)
  private IssueLinkType type;
  @DatabaseField(foreign = true)
  private Issue outwardIssue;
  @DatabaseField(foreign = true)
  private Issue inwardIssue;

  public IssueLinkType getType() {
    return type;
  }

  public void setType(IssueLinkType type) {
    this.type = type;
  }

  public Issue getOutwardIssue() {
    return outwardIssue;
  }

  public void setOutwardIssue(Issue outwardIssue) {
    this.outwardIssue = outwardIssue;
  }

  public Issue getInwardIssue() {
    return inwardIssue;
  }

  public void setInwardIssue(Issue inwardIssue) {
    this.inwardIssue = inwardIssue;
  }

}

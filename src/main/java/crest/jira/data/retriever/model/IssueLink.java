package crest.jira.data.retriever.model;

public class IssueLink extends JiraEntity {

  private IssueLinkType type;
  private Issue outwardIssue;
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

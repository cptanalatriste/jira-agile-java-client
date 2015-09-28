package crest.jira.data.retriever.model;

public class IssueLinkType extends JiraEntity {
  private String inward;
  private String outward;

  public String getInward() {
    return inward;
  }

  public void setInward(String inward) {
    this.inward = inward;
  }

  public String getOutward() {
    return outward;
  }

  public void setOutward(String outward) {
    this.outward = outward;
  }

}

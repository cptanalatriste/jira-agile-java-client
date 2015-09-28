package crest.jira.data.retriever.model;

public class IssueType extends JiraEntity {
  
  private String iconUrl;
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

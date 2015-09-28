package crest.jira.data.retriever.model;

public class Status extends JiraEntity {

  private String iconUrl;
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

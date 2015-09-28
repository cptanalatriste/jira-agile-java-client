package crest.jira.data.retriever.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties({ "avatarUrls" })
public class Project extends JiraEntity {

  private ProjectCategory projectCategory;

  public ProjectCategory getProjectCategory() {
    return projectCategory;
  }

  public void setProjectCategory(ProjectCategory projectCategory) {
    this.projectCategory = projectCategory;
  }
}

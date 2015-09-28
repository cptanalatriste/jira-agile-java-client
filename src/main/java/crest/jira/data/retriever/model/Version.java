package crest.jira.data.retriever.model;

import java.util.Date;

public class Version extends JiraEntity {

  private String projectId;
  private boolean archived;
  private boolean released;
  private Date releaseDate;

  public boolean isArchived() {
    return archived;
  }

  public void setArchived(boolean archived) {
    this.archived = archived;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public boolean isReleased() {
    return released;
  }

  public void setReleased(boolean released) {
    this.released = released;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

}

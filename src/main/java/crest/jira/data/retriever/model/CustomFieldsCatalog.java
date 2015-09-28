package crest.jira.data.retriever.model;

import java.util.Date;

public class CustomFieldsCatalog {
  private Double storyPoints;
  private Sprint[] sprint;
  private Date dateOfFirstResponse;
  private String globalRank;
  private String timeInStatus;
  private Double attachmentCount;
  private Version[] targetVersion;
  private String rank;
  private User shepherd;

  public Double getStoryPoints() {
    return storyPoints;
  }

  public void setStoryPoints(Double storyPoints) {
    this.storyPoints = storyPoints;
  }

  public Sprint[] getSprint() {
    return sprint;
  }

  public void setSprint(Sprint[] rawSprints) {
    this.sprint = rawSprints;
  }

  public Date getDateOfFirstResponse() {
    return dateOfFirstResponse;
  }

  public void setDateOfFirstResponse(Date dateOfFirstResponse) {
    this.dateOfFirstResponse = dateOfFirstResponse;
  }

  public String getGlobalRank() {
    return globalRank;
  }

  public void setGlobalRank(String globalRank) {
    this.globalRank = globalRank;
  }

  public String getTimeInStatus() {
    return timeInStatus;
  }

  public void setTimeInStatus(String timeInStatus) {
    this.timeInStatus = timeInStatus;
  }

  public Double getAttachmentCount() {
    return attachmentCount;
  }

  public void setAttachmentCount(Double attachmentCount) {
    this.attachmentCount = attachmentCount;
  }

  public Version[] getTargetVersion() {
    return targetVersion;
  }

  public void setTargetVersion(Version[] targetVersion) {
    this.targetVersion = targetVersion;
  }

  public String getRank() {
    return rank;
  }

  public void setRank(String rank) {
    this.rank = rank;
  }

  public User getShepherd() {
    return shepherd;
  }

  public void setShepherd(User shepherd) {
    this.shepherd = shepherd;
  }

}

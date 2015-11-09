package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "CustomFieldsCatalog")
public class CustomFieldsCatalog {

  @DatabaseField(id = true)
  private String issueId;
  @DatabaseField
  private Double storyPoints;
  // @DatabaseField(foreign = true)
  private Sprint[] sprint;
  @DatabaseField
  private Date dateOfFirstResponse;
  @DatabaseField
  private String globalRank;
  @DatabaseField
  private String timeInStatus;
  @DatabaseField
  private Double attachmentCount;
  // @DatabaseField(foreign = true)
  private Version[] targetVersion;
  @DatabaseField
  private String rank;
  @DatabaseField(foreign = true)
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

  public String getIssueId() {
    return issueId;
  }

  public void setIssueId(String issueId) {
    this.issueId = issueId;
  }
}

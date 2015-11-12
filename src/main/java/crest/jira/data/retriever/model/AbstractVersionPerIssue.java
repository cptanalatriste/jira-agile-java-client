package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;

public abstract class AbstractVersionPerIssue extends BoardRelatedEntity {

  @DatabaseField(foreign = true, columnName = "issueId")
  private Issue issue;
  @DatabaseField(foreign = true, columnName = "versionId")
  private Version version;

  /**
   * Represents a relation between an Issue and a Version.
   * 
   * @param issue
   *          The issue.
   * @param version
   *          The version.
   */
  public AbstractVersionPerIssue(Issue issue, Version version) {
    super(issue.getBoardId());
    this.issue = issue;
    this.version = version;
  }

  public Issue getIssue() {
    return issue;
  }

  public void setIssue(Issue issue) {
    this.issue = issue;
  }

  public Version getVersion() {
    return version;
  }

  public void setVersion(Version version) {
    this.version = version;
  }

}

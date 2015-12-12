package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

@DatabaseTable(tableName = "Version")
public class Version extends JiraEntity {

  @DatabaseField(index = true)
  private String projectId;
  @DatabaseField
  private boolean archived;
  @DatabaseField
  private boolean released;
  @DatabaseField(index = true)
  private Date releaseDate;

  public Version() {

  }

  public Version(String name, Date releaseDate) {
    this.setName(name);
    this.releaseDate = releaseDate;
  }

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

  @Override
  public String toString() {
    return this.getName();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(this.getId()).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }

    JiraEntity rhs = (JiraEntity) obj;
    return new EqualsBuilder().append(this.getId(), rhs.getId()).isEquals();
  }

}

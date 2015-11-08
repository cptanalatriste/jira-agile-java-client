package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

@DatabaseTable(tableName = "Sprint")
public class Sprint extends JiraEntity {

  @DatabaseField
  private String state;
  @DatabaseField
  private Date startDate;
  @DatabaseField
  private Date endDate;
  @DatabaseField
  private Date completeDate;
  @DatabaseField
  private String originBoardId;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Date getCompleteDate() {
    return completeDate;
  }

  public void setCompleteDate(Date completeDate) {
    this.completeDate = completeDate;
  }

  public String getOriginBoardId() {
    return originBoardId;
  }

  public void setOriginBoardId(String originBoardId) {
    this.originBoardId = originBoardId;
  }

  @Override
  public int hashCode() {
    int superHashCode = super.hashCode();
    return new HashCodeBuilder().appendSuper(superHashCode).toHashCode();
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
    return new EqualsBuilder().appendSuper(super.equals(obj)).isEquals();
  }

}

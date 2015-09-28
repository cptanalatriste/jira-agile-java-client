package crest.jira.data.retriever.model;

import java.util.Date;

public class Sprint extends JiraEntity {

  private String state;
  private Date startDate;
  private Date endDate;
  private Date completeDate;
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

}

package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "History")
public class History {

  @DatabaseField(id = true)
  private String id;
  @DatabaseField(foreign = true, columnName = "authorId")
  private User author;
  @DatabaseField
  private Date created;
  @DatabaseField(index = true)
  private String issueId;

  private ChangeLogItem[] items;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public ChangeLogItem[] getItems() {
    return items;
  }

  /**
   * Assigns a group of Change Log Items to a History, configuring a proper
   * History Id for each item.
   * 
   * @param items
   *          List of Change Log Items.
   */
  public void setItems(ChangeLogItem[] items) {
    this.items = items;

    for (ChangeLogItem changeLogItem : items) {
      changeLogItem.setHistoryId(this.getId());
    }
  }

  public String getIssueId() {
    return issueId;
  }

  public void setIssueId(String issueId) {
    this.issueId = issueId;
  }

}

package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "History")
public class History {

  @DatabaseField
  private String id;
  @DatabaseField(foreign = true)
  private User author;

  @DatabaseField
  private Date created;

  @DatabaseField(foreign = true)
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

  public void setItems(ChangeLogItem[] items) {
    this.items = items;
  }

}

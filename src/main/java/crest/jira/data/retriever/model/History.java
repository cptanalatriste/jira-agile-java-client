package crest.jira.data.retriever.model;

import java.util.Date;

public class History {

  private String id;
  private User author;
  private Date created;
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

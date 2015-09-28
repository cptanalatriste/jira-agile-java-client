package crest.jira.data.retriever.model;

import java.util.Date;

public class Comment extends JiraEntity {
  private User author;
  private String body;
  private User updateAuthor;
  private Date created;
  private Date updated;

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public User getUpdateAuthor() {
    return updateAuthor;
  }

  public void setUpdateAuthor(User updateAuthor) {
    this.updateAuthor = updateAuthor;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

}

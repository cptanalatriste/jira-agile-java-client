package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Comment")
public class Comment extends JiraEntity {

  @DatabaseField(foreign = true)
  private User author;

  @DatabaseField
  private String body;

  @DatabaseField(foreign = true)
  private User updateAuthor;

  @DatabaseField
  private Date created;

  @DatabaseField
  private Date updated;

  @DatabaseField
  private Visibility visibility;

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

  public Visibility getVisibility() {
    return visibility;
  }

  public void setVisibility(Visibility visibility) {
    this.visibility = visibility;
  }

}

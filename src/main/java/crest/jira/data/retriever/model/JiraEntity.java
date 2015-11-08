package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class JiraEntity {

  @DatabaseField(id = true)
  private String id;
  @DatabaseField
  private String self;
  @DatabaseField
  private String name;
  @DatabaseField
  private String description;
  @DatabaseField
  private String key;
  @DatabaseField
  private String expand;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getExpand() {
    return expand;
  }

  public void setExpand(String expand) {
    this.expand = expand;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id).toHashCode();
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
    return new EqualsBuilder().append(id, rhs.id).isEquals();
  }

}

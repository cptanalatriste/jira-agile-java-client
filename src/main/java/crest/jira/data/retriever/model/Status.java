package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Status")
public class Status extends JiraEntity {
  @DatabaseField
  private String iconUrl;
  @DatabaseField(foreign = true, columnName = "statusCategoryId")
  private StatusCategory statusCategory;

  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  public StatusCategory getStatusCategory() {
    return statusCategory;
  }

  public void setStatusCategory(StatusCategory statusCategory) {
    this.statusCategory = statusCategory;
  }

}

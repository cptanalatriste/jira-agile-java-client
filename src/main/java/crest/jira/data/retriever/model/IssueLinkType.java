package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "IssueLinkType")
public class IssueLinkType extends JiraEntity {
  @DatabaseField
  private String inward;
  @DatabaseField
  private String outward;

  public String getInward() {
    return inward;
  }

  public void setInward(String inward) {
    this.inward = inward;
  }

  public String getOutward() {
    return outward;
  }

  public void setOutward(String outward) {
    this.outward = outward;
  }

}

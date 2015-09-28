package crest.jira.data.retriever.model;

public class Schema {

  private String type;
  private String items;
  private String system;
  private String custom;
  private String customId;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getItems() {
    return items;
  }

  public void setItems(String items) {
    this.items = items;
  }

  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public String getCustom() {
    return custom;
  }

  public void setCustom(String custom) {
    this.custom = custom;
  }

  public String getCustomId() {
    return customId;
  }

  public void setCustomId(String customId) {
    this.customId = customId;
  }

}

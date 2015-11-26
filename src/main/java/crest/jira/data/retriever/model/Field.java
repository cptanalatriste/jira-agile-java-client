package crest.jira.data.retriever.model;

public class Field extends JiraEntity {

  private boolean custom;
  private boolean orderable;
  private boolean navigable;
  private boolean searchable;
  private String[] clauseNames;
  private Schema schema;

  public boolean getCustom() {
    return custom;
  }

  public void setCustom(boolean custom) {
    this.custom = custom;
  }

  public boolean getOrderable() {
    return orderable;
  }

  public void setOrderable(boolean orderable) {
    this.orderable = orderable;
  }

  public boolean getNavigable() {
    return navigable;
  }

  public void setNavigable(boolean navigable) {
    this.navigable = navigable;
  }

  public String[] getClauseNames() {
    return clauseNames;
  }

  public void setClauseNames(String[] clauseNames) {
    this.clauseNames = clauseNames;
  }

  public Schema getSchema() {
    return schema;
  }

  public void setSchema(Schema schema) {
    this.schema = schema;
  }

  public boolean getSearchable() {
    return searchable;
  }

  public void setSearchable(boolean searchable) {
    this.searchable = searchable;
  }
}

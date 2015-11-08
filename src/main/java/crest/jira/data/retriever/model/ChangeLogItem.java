package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ChangeLogItem")
public class ChangeLogItem {
  
  @DatabaseField
  private String field;
  
  @DatabaseField
  private String fieldtype;
  
  @DatabaseField
  private String from;
  
  @DatabaseField
  private String fromString;
  
  @DatabaseField
  private String to;
  
  @DatabaseField
  private String toString;

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getFromString() {
    return fromString;
  }

  public void setFromString(String fromString) {
    this.fromString = fromString;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getToString() {
    return toString;
  }

  public void setToString(String toString) {
    this.toString = toString;
  }

  public String getFieldtype() {
    return fieldtype;
  }

  public void setFieldtype(String fieldtype) {
    this.fieldtype = fieldtype;
  }

}

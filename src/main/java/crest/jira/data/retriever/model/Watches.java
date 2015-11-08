package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Watches")
public class Watches {

  @DatabaseField
  private String self;
  @DatabaseField
  private int watchCount;
  @DatabaseField
  private boolean isWatching;

  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public int getWatchCount() {
    return watchCount;
  }

  public void setWatchCount(int watchCount) {
    this.watchCount = watchCount;
  }

  public boolean getIsWatching() {
    return isWatching;
  }

  public void setIsWatching(boolean isWatching) {
    this.isWatching = isWatching;
  }

}

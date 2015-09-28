package crest.jira.data.retriever.model;

public class Watches {

  private String self;
  private int watchCount;
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

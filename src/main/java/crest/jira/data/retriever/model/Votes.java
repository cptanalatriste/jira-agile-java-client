package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Votes")
public class Votes {

  @DatabaseField
  private String self;

  @DatabaseField
  private int votes;

  @DatabaseField
  private boolean hasVoted;

  public int getVotes() {
    return votes;
  }

  public void setVotes(int votes) {
    this.votes = votes;
  }

  public boolean getHasVoted() {
    return hasVoted;
  }

  public void setHasVoted(boolean hasVoted) {
    this.hasVoted = hasVoted;
  }

  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

}

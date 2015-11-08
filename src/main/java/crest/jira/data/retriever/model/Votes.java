package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Votes")
public class Votes extends JiraEntity {

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

}

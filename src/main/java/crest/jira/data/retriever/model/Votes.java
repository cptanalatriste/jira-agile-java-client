package crest.jira.data.retriever.model;

public class Votes extends JiraEntity {

  private int votes;
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

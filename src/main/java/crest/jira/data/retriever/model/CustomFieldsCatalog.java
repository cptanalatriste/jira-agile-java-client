package crest.jira.data.retriever.model;

public class CustomFieldsCatalog {
  private double storyPoints;
  private Sprint[] sprint;

  public double getStoryPoints() {
    return storyPoints;
  }

  public void setStoryPoints(double storyPoints) {
    this.storyPoints = storyPoints;
  }

  public Sprint[] getSprint() {
    return sprint;
  }

  public void setSprint(Sprint[] rawSprints) {
    this.sprint = rawSprints;
  }

}

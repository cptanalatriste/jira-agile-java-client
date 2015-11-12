package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ComponentsPerIssue")
public class ComponentPerIssue extends BoardRelatedEntity {

  @DatabaseField(foreign = true, columnName = "componentId")
  private Component component;
  @DatabaseField(foreign = true, columnName = "issueId")
  private Issue issue;

  public ComponentPerIssue() {
    super(null);
  }

  /**
   * Generates a relation between a Component and an Issue.
   * 
   * @param component
   *          The component.
   * @param issue
   *          The issue.
   */
  public ComponentPerIssue(Component component, Issue issue) {
    super(issue.getBoardId());
    this.component = component;
    this.issue = issue;
  }

  public Component getComponent() {
    return component;
  }

  public void setComponent(Component component) {
    this.component = component;
  }

  public Issue getIssue() {
    return issue;
  }

  public void setIssue(Issue issue) {
    this.issue = issue;
  }

}

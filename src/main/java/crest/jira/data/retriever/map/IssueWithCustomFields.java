package crest.jira.data.retriever.map;

import crest.jira.data.retriever.model.CustomFieldsCatalog;
import crest.jira.data.retriever.model.Issue;

public class IssueWithCustomFields {

  private Issue issue;
  private CustomFieldsCatalog customFields;

  /**
   * Initializes type attributes.
   * 
   * @param issue
   *          Issue information.
   * @param customFields
   *          Custom Field Information.
   */
  public IssueWithCustomFields(Issue issue, CustomFieldsCatalog customFields) {
    super();
    this.issue = issue;
    this.customFields = customFields;
  }

  public Issue getIssue() {
    return issue;
  }

  public void setIssue(Issue issue) {
    this.issue = issue;
  }

  public CustomFieldsCatalog getCustomFields() {
    return customFields;
  }

  public void setCustomFields(CustomFieldsCatalog customFields) {
    this.customFields = customFields;
  }

}

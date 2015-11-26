package crest.jira.data.retriever;

public class JiraApiConfiguration {

  private String contentType;
  private String authenticationValue;
  private String hostAndContext;

  /**
   * Stores a configuration for a Given Jira environment.
   * 
   * @param contentType
   *          Expected content type.
   * @param authenticationValue
   *          Authentication Header value
   * @param hostAndContext
   *          Host and context of the environment.
   */
  public JiraApiConfiguration(String contentType, String authenticationValue,
      String hostAndContext) {
    super();
    this.contentType = contentType;
    this.authenticationValue = authenticationValue;
    this.hostAndContext = hostAndContext;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getAuthenticationValue() {
    return authenticationValue;
  }

  public void setAuthenticationValue(String authenticationValue) {
    this.authenticationValue = authenticationValue;
  }

  public String getHostAndContext() {
    return hostAndContext;
  }

  public void setHostAndContext(String hostAndContext) {
    this.hostAndContext = hostAndContext;
  }

}

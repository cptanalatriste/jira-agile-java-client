package crest.jira.data.retriever;

import org.apache.commons.codec.binary.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

public abstract class BaseRetriever {

  private static final String AUTH_HEADER_NAME = "Authorization";
  private static final String AUTH_VALUE_PREFIX = " Basic ";

  private Client client;
  private JiraApiConfiguration configuration;

  /**
   * Initializes attributes.
   * 
   * @param client
   *          Client instance.
   * @param configuration
   *          Configuration instance.
   * @param fields
   *          Field information.
   */
  public BaseRetriever(Client client, JiraApiConfiguration configuration) {
    this.client = client;
    this.configuration = configuration;
  }

  protected Builder getBuilder(WebTarget target) {
    Builder builder = target.request(configuration.getContentType());
    String authorizationHeaderValue = getAuthorizationHeaderValue();

    builder.header(AUTH_HEADER_NAME, authorizationHeaderValue);
    return builder;
  }

  private String getAuthorizationHeaderValue() {
    String authorizationValue = configuration.getAuthenticationValue();
    byte[] encodedBytes = Base64.encodeBase64(authorizationValue.getBytes());
    return AUTH_VALUE_PREFIX + new String(encodedBytes);
  }

  public JiraApiConfiguration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(JiraApiConfiguration configuration) {
    this.configuration = configuration;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}

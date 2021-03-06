package crest.jira.data.retriever;

import org.apache.commons.codec.binary.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

public abstract class BaseRetriever {

  private static final String EXPAND_PARAM = "expand";
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

  protected WebTarget addExpandSupport(WebTarget target, String... expand) {
    String expandValue = "";
    for (String expandItem : expand) {
      expandValue += expandItem + ",";
    }

    String queryParamValue = expandValue.substring(0, expandValue.length() - 1);

    target = target.queryParam(EXPAND_PARAM, queryParamValue);
    return target;
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

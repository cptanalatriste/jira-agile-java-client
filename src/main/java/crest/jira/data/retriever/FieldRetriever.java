package crest.jira.data.retriever;

import crest.jira.data.retriever.model.Field;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;

import javax.ws.rs.client.WebTarget;

public class FieldRetriever extends BaseRetriever {

  private static final String ALL_FIELDS_RESOURCE = "/rest/api/latest/field";

  public FieldRetriever(Client client, JiraApiConfiguration configuration) {
    super(client, configuration);
  }

  /**
   * Returns custom field information.
   * 
   * @return List of Field instances.
   */
  public Field[] getFields() {
    String uri = getConfiguration().getHostAndContext() + ALL_FIELDS_RESOURCE;

    WebTarget target = getClient().target(uri);
    Builder builder = getBuilder(target);

    return builder.get(Field[].class);
  }

}

package crest.jira.data.retriever;

import crest.jira.data.retriever.map.ResponseList;
import crest.jira.data.retriever.model.Version;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class VersionRetriever extends BaseRetriever {

  private static final String VERSION_PATH = "/{boardId}/version";

  public VersionRetriever(Client client, JiraApiConfiguration configuration) {
    super(client, configuration);
  }

  /**
   * Returns all versions related to a board.
   * 
   * @param boardId
   *          Board identifier.
   * @return List of versions.
   */
  public ResponseList<Version> getAllVersions(String boardId) {
    String uri = getConfiguration().getHostAndContext() + BoardRetriever.ALL_BOARDS_RESOURCE
        + VERSION_PATH;
    WebTarget target = getClient().target(uri).resolveTemplate("boardId", boardId);

    return getBuilder(target).get(new GenericType<ResponseList<Version>>() {

    });
  }
}

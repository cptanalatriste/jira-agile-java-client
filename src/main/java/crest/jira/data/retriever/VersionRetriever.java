package crest.jira.data.retriever;

import crest.jira.data.retriever.map.ResponseList;
import crest.jira.data.retriever.model.Version;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class VersionRetriever extends BaseRetriever {

  private static final String VERSION_PATH = "/{boardId}/version";
  private PaginationBuilder<Version> paginationBuilder;

  public VersionRetriever(Client client, JiraApiConfiguration configuration) {
    super(client, configuration);
    this.paginationBuilder = new PaginationBuilder<>(this);
  }

  /**
   * Returns all versions related to a board.
   * 
   * @param boardId
   *          Board identifier.
   * @return List of versions.
   * @throws ParseException
   *           In case of map parsing issues.
   */
  public List<Version> getAllVersions(String boardId) throws ParseException {
    String uri = getConfiguration().getHostAndContext() + BoardRetriever.ALL_BOARDS_RESOURCE
        + VERSION_PATH;
    WebTarget target = getClient().target(uri).resolveTemplate("boardId", boardId);

    List<Version> versions = paginationBuilder.get(target,
        new GenericType<ResponseList<Version>>() {

        }, null);

    return versions;
  }
}

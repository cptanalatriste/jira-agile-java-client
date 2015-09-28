package crest.jira.data.retriever;

import crest.jira.data.retriever.map.ResponseList;
import crest.jira.data.retriever.model.Board;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class BoardRetriever extends BaseRetriever {

  public static final String ALL_BOARDS_RESOURCE = "/rest/agile/latest/board";

  public BoardRetriever(Client client, JiraApiConfiguration configuration) {
    super(client, configuration);
  }

  /**
   * Returns the information of an specific board.
   * 
   * @param boardId
   *          Board identifier.
   * @return Board information.
   */
  public Board getBoard(String boardId) {
    String uri = getConfiguration().getHostAndContext() + ALL_BOARDS_RESOURCE + "/{boardId}";
    WebTarget target = getClient().target(uri).resolveTemplate("boardId", boardId);
    Builder builder = getBuilder(target);

    return builder.get(Board.class);
  }

  /**
   * Returns all the boards on the Jira instance.
   * 
   * @return List of all boards.
   */
  public ResponseList<Board> getAllBoards() {
    String uri = getConfiguration().getHostAndContext() + ALL_BOARDS_RESOURCE;

    Builder builder = getBuilder(getClient().target(uri));
    return builder.get(new GenericType<ResponseList<Board>>() {

    });
  }

  public void getIssuesForBacklog() {
    // TODO(cgavidia): Pending, currently the resourse is producing errors.
    // Check https://issues.apache.org/jira/rest/agile/1.0/board/35/backlog
  }

  public void getIssuesForBoard() {
    // TODO(cgavidia): Pending, currently the resourse is producing errors.
    // Check https://issues.apache.org/jira/rest/agile/1.0/board/35/backlog
  }

}

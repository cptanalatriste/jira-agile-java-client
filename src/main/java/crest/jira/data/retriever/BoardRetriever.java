package crest.jira.data.retriever;

import crest.jira.data.retriever.map.IssueListMapper;
import crest.jira.data.retriever.map.IssueWithCustomFields;
import crest.jira.data.retriever.map.ResponseList;
import crest.jira.data.retriever.model.Board;
import crest.jira.data.retriever.model.Field;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class BoardRetriever extends BaseRetriever {

  public static final String ALL_BOARDS_RESOURCE = "/rest/agile/latest/board";

  private Field[] fields;

  public BoardRetriever(Client client, JiraApiConfiguration configuration, Field[] fields) {
    super(client, configuration);
    this.fields = fields;
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

  /**
   * Returns all the issues for an specific board.
   * 
   * @param boardId
   *          Board identifier.
   * @param expand
   *          Expand parameter.
   * @return List of Issues with Custom Fields.
   * @throws ParseException
   *           Something might happen.
   */
  public List<IssueWithCustomFields> getIssuesForBoard(String boardId, String... expand)
      throws ParseException {
    String uri = getConfiguration().getHostAndContext() + ALL_BOARDS_RESOURCE + "/{boardId}/issue";
    WebTarget target = getClient().target(uri).resolveTemplate("boardId", boardId);
    if (expand != null && expand.length > 0) {
      target = addExpandSupport(target, expand);
    }

    IssueListMapper issueListMapper = new IssueListMapper(fields);
    PaginationBuilder<IssueWithCustomFields> builder = new PaginationBuilder<IssueWithCustomFields>(
        this);
    List<IssueWithCustomFields> issues = builder.get(target, null, issueListMapper);
    return issues;
  }

  public void getIssuesForBacklog() {
    // TODO(cgavidia): Pending, currently the resourse is producing errors.
    // Check https://issues.apache.org/jira/rest/agile/1.0/board/35/backlog
  }

}

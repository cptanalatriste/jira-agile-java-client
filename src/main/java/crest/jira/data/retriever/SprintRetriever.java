package crest.jira.data.retriever;

import crest.jira.data.retriever.map.IssueListMapper;
import crest.jira.data.retriever.map.IssueWithCustomFields;
import crest.jira.data.retriever.map.ResponseList;
import crest.jira.data.retriever.model.Field;
import crest.jira.data.retriever.model.Sprint;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class SprintRetriever extends BaseRetriever {

  private static Logger logger = Logger.getLogger(SprintRetriever.class.getName());

  private static final String SPRINT_UNSUPPORTED = 
      "Bad Request. It is possible that this board doesn't support Sprints";
  private static final String SPRINT_PER_BOARD_PATH = "/{boardId}/sprint";
  private static final String SPRINT_PATH = "/rest/agile/latest/sprint/{sprintId}";

  private Field[] fields;

  public SprintRetriever(Client client, JiraApiConfiguration configuration, Field[] fields) {
    super(client, configuration);
    this.fields = fields;
  }

  /**
   * Retrieves Sprint information.
   * 
   * @param sprintId
   *          Sprint identifier.
   * @return Sprint instance.
   */
  public Sprint getSprint(String sprintId) {
    String uri = getConfiguration().getHostAndContext() + SPRINT_PATH;
    WebTarget target = getClient().target(uri).resolveTemplate("sprintId", sprintId);

    return getBuilder(target).get(Sprint.class);
  }

  /**
   * Returns all Sprints in a given board.
   * 
   * @param boardId
   *          Board Identifier.
   * @return List of Sprints.
   */
  public ResponseList<Sprint> getAllSprints(String boardId) {
    String uri = getConfiguration().getHostAndContext() + BoardRetriever.ALL_BOARDS_RESOURCE
        + SPRINT_PER_BOARD_PATH;
    WebTarget target = getClient().target(uri).resolveTemplate("boardId", boardId);
    Builder builder = getBuilder(target);

    logger.info("Requesting the following Resource: " + target.getUri());

    Response response = builder.get(Response.class);
    if (response.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {
      logger.info(SPRINT_UNSUPPORTED + "\n Board Id: " + boardId);
      return null;
    }

    return response.readEntity(new GenericType<ResponseList<Sprint>>() {

    });
  }

  /**
   * Returns a list of issues related to an Sprint.
   * 
   * @param boardId
   *          Board identifier.
   * @param sprintId
   *          Sprint identifier.
   * @return List of issues
   * @throws ParseException
   *           In case of Date Parsing problems.
   */
  public List<IssueWithCustomFields> getIssuesForSprint(String boardId, String sprintId,
      String... expand) throws ParseException {
    String uri = getConfiguration().getHostAndContext() + BoardRetriever.ALL_BOARDS_RESOURCE
        + SPRINT_PER_BOARD_PATH + "/{sprintId}/issue";
    Map<String, Object> templateValues = new HashMap<String, Object>();
    templateValues.put("boardId", boardId);
    templateValues.put("sprintId", sprintId);

    WebTarget target = getClient().target(uri).resolveTemplates(templateValues);
    if (expand != null && expand.length > 0) {
      target = addExpandSupport(target, expand);
    }

    IssueListMapper issueListMapper = new IssueListMapper(fields);

    PaginationBuilder<IssueWithCustomFields> builder = new PaginationBuilder<IssueWithCustomFields>(
        this);
    List<IssueWithCustomFields> issues = builder.get(target, null, issueListMapper);
    return issues;
  }
}

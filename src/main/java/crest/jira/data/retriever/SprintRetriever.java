package crest.jira.data.retriever;

import crest.jira.data.retriever.map.IssueListMapper;
import crest.jira.data.retriever.map.IssueWithCustomFields;
import crest.jira.data.retriever.map.ResponseList;
import crest.jira.data.retriever.model.Field;
import crest.jira.data.retriever.model.Sprint;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class SprintRetriever extends BaseRetriever {

  private static final String SPRINT_PATH = "/{boardId}/sprint";
  private Field[] fields;

  public SprintRetriever(Client client, JiraApiConfiguration configuration, Field[] fields) {
    super(client, configuration);
    this.fields = fields;
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
        + SPRINT_PATH;
    WebTarget target = getClient().target(uri).resolveTemplate("boardId", boardId);
    Builder builder = getBuilder(target);

    return builder.get(new GenericType<ResponseList<Sprint>>() {

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
  public ResponseList<IssueWithCustomFields> getIssuesForSprint(String boardId, String sprintId)
      throws ParseException {
    String uri = getConfiguration().getHostAndContext() + BoardRetriever.ALL_BOARDS_RESOURCE
        + SPRINT_PATH + "/{sprintId}/issue";
    Map<String, Object> templateValues = new HashMap<String, Object>();
    templateValues.put("boardId", boardId);
    templateValues.put("sprintId", sprintId);

    WebTarget target = getClient().target(uri).resolveTemplates(templateValues);
    Builder builder = getBuilder(target);

    IssueListMapper issueListMapper = new IssueListMapper(fields);
    return issueListMapper.map(builder.get(Map.class));
  }
}

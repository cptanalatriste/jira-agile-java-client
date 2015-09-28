package crest.jira.data.retriever;

import crest.jira.data.retriever.map.IssueListMapper;
import crest.jira.data.retriever.map.ResponseList;
import crest.jira.data.retriever.model.Epic;
import crest.jira.data.retriever.model.Field;
import crest.jira.data.retriever.model.Issue;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class EpicRetriever extends BaseRetriever {

  private static final String EPIC_PATH = "/{boardId}/epic";
  private Field[] fields;

  public EpicRetriever(Client client, JiraApiConfiguration configuration, Field[] fields) {
    super(client, configuration);
    this.fields = fields;
  }

  /**
   * Returns all epics from a board.
   * 
   * @param mesosBoardId
   *          Board identifier.
   * @return List of Epics.
   */
  public ResponseList<Epic> getEpics(String mesosBoardId) {
    String uri = getConfiguration().getHostAndContext() + BoardRetriever.ALL_BOARDS_RESOURCE
        + EPIC_PATH;
    WebTarget target = getClient().target(uri).resolveTemplate("boardId", mesosBoardId);
    Builder builder = getBuilder(target);

    return builder.get(new GenericType<ResponseList<Epic>>() {

    });
  }

  /**
   * Returns a list of issues related to an epic.
   * 
   * @param mesosBoardId
   *          Board identifier.
   * @param epicId
   *          Epic identifier.
   * @return List of issues.
   * @throws ParseException
   *           In case of Date Parsing problems.
   */
  public ResponseList<Issue> getIssuesForEpic(String mesosBoardId, long epicId)
      throws ParseException {
    String uri = getConfiguration().getHostAndContext() + BoardRetriever.ALL_BOARDS_RESOURCE
        + EPIC_PATH + "/{epicId}/issue";
    Map<String, Object> templateValues = new HashMap<String, Object>();
    templateValues.put("boardId", mesosBoardId);
    templateValues.put("epicId", epicId);

    WebTarget target = getClient().target(uri).resolveTemplates(templateValues);
    Builder builder = getBuilder(target);

    IssueListMapper issueListMapper = new IssueListMapper(fields);
    return issueListMapper.map(builder.get(Map.class));

  }
}

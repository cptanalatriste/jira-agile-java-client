package crest.jira.data.retriever;

import crest.jira.data.retriever.map.ResponseList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class PaginationBuilder<T> {

  private static Logger logger = Logger.getLogger(PaginationBuilder.class.getName());

  private static final String START_AT_PARAMETER = "startAt";

  private BaseRetriever retriever;

  public PaginationBuilder(BaseRetriever retriever) {
    this.retriever = retriever;
  }

  /**
   * Returns a list of objects taking pagination into account.
   * 
   * @return List of objects.
   */
  public List<T> get(WebTarget webTarget, GenericType<ResponseList<T>> responseType) {
    List<T> itemList = new ArrayList<T>();
    int currentPage = 0;
    boolean requestNextPage = true;

    while (requestNextPage) {
      Object initialValue = null;
      // This is for clearing the startAt value
      webTarget = webTarget.queryParam(START_AT_PARAMETER, initialValue);
      webTarget = webTarget.queryParam(START_AT_PARAMETER, currentPage);
      Builder builder = retriever.getBuilder(webTarget);

      logger.info("Requesting the following Resource: " + webTarget.getUri());

      ResponseList<T> responseList = builder.get(responseType);
      logger.info("responseList.getStartAt()" + responseList.getStartAt());
      logger.info("responseList.getIsLast()" + responseList.getIsLast());

      itemList.addAll(Arrays.asList(responseList.getValues()));

      requestNextPage = !responseList.getIsLast();
      currentPage += 1;
    }

    return itemList;
  }

}

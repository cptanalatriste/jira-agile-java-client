package crest.jira.data.retriever;

import crest.jira.data.retriever.map.ResponseList;
import crest.jira.data.retriever.map.ResponseListMapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
   * @throws ParseException
   *           When dealing with raw maps.
   */
  // TODO(cgavidia): Temporary UGLY solution.
  public List<T> get(WebTarget webTarget, GenericType<ResponseList<T>> responseType,
      ResponseListMapper<T> listMapper) throws ParseException {
    List<T> itemList = new ArrayList<T>();
    int startFrom = 0;
    int pageSize = 1;
    boolean requestNextPage = true;
    int totalItems = 1;

    while (requestNextPage && startFrom <= totalItems) {
      Object initialValue = null;
      // This is for clearing the startAt value
      webTarget = webTarget.queryParam(START_AT_PARAMETER, initialValue);
      webTarget = webTarget.queryParam(START_AT_PARAMETER, startFrom);
      Builder builder = retriever.getBuilder(webTarget);

      logger.info("Requesting the following Resource: " + webTarget.getUri());

      try {
        ResponseList<T> responseList = new ResponseList<T>();

        if (responseType != null) {
          responseList = getResponseList(builder, responseType);
        } else if (listMapper != null) {
          responseList = getResponseList(builder, listMapper);
        }

        totalItems = responseList.getTotal();
        logger.info("Target " + totalItems);

        itemList.addAll(Arrays.asList(responseList.getValues()));

        if (responseList.getIsLast() != null) {
          requestNextPage = !responseList.getIsLast();
        } else {
          requestNextPage = responseList.getValues().length > 0;
        }
        pageSize = responseList.getValues().length;
      } catch (Exception e) {
        logger.severe("An error ocurred while trying to access resource:  " + webTarget.getUri()
            + "\n. We will attempt to fetch th next page.");
        e.printStackTrace();

        requestNextPage = true;
      }

      startFrom += pageSize;
    }

    return itemList;
  }

  private ResponseList<T> getResponseList(Builder builder,
      GenericType<ResponseList<T>> responseType) {
    return builder.get(responseType);
  }

  @SuppressWarnings({ "rawtypes" })
  private ResponseList<T> getResponseList(Builder builder, ResponseListMapper<T> listMapper)
      throws ParseException {
    Map responseAsMap = builder.get(Map.class);
    return listMapper.map(responseAsMap);
  }

}

package crest.jira.data.retriever.map;

import org.codehaus.jackson.map.ObjectMapper;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResponseListMapper<T> {
  private String valueAttribute;
  private ObjectMapper objectMapper;
  private Class<T> clazz;

  /**
   * Creates a new Mapper instance.
   * 
   * @param valueAttribute
   *          Value that contains the list.
   * @param clazzParameter
   *          Class of the items in the list.
   */
  public ResponseListMapper(String valueAttribute, Class<T> clazzParameter) {
    this.valueAttribute = valueAttribute;
    this.objectMapper = new ObjectMapper();
    this.clazz = clazzParameter;
  }

  /**
   * Maps a list of items to the corresponding type
   * 
   * @param map
   *          List representation.
   * @return ResponseList instance.
   * @throws ParseException
   *           In case of Date parsing problems.
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public ResponseList<T> map(Map map) throws ParseException {
    ResponseList<T> responseList = new ResponseList<T>();

    Object expandInMap = map.get("expand");
    if (expandInMap != null) {
      responseList.setExpand((String) expandInMap);
    }
    responseList.setStartAt((Integer) map.get("startAt"));
    responseList.setMaxResults((Integer) map.get("maxResults"));
    responseList.setTotal((Integer) map.get("total"));

    List<T> itemList = new ArrayList<T>();

    for (Map<String, Object> issueMap : (ArrayList<Map<String, Object>>) map.get(valueAttribute)) {
      T item = getItem(issueMap);
      itemList.add(item);
    }
    responseList.setValues(itemList.toArray((T[]) Array.newInstance(clazz, itemList.size())));
    return responseList;
  }

  protected T getItem(Map<String, Object> issueMap) throws ParseException {
    return this.objectMapper.convertValue(issueMap, clazz);
  }

}

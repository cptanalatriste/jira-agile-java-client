package crest.jira.data.retriever.map;

public class ResponseList<T> {

  // TODO(cgavidia): Handle pagination.
  private String expand;
  private int maxResults;
  private int startAt;
  private int total;
  private boolean isLast;
  private T[] values;

  public int getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(int maxResults) {
    this.maxResults = maxResults;
  }

  public int getStartAt() {
    return startAt;
  }

  public void setStartAt(int startAt) {
    this.startAt = startAt;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public boolean getIsLast() {
    return isLast;
  }

  public void setIsLast(boolean isLast) {
    this.isLast = isLast;
  }

  public T[] getValues() {
    return values;
  }

  public void setValues(T[] values) {
    this.values = values;
  }

  public String getExpand() {
    return expand;
  }

  public void setExpand(String expand) {
    this.expand = expand;
  }

}

package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;

public class BoardRelatedEntity {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String boardId;

  public BoardRelatedEntity(String boardId) {
    this.boardId = boardId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBoardId() {
    return boardId;
  }

  public void setBoardId(String boardId) {
    this.boardId = boardId;
  }

}

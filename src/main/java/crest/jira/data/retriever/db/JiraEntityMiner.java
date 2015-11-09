package crest.jira.data.retriever.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import crest.jira.data.retriever.map.ResponseList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class JiraEntityMiner<T, I> {

  private static final String PAGINATION_ERROR_MSG = "The results will come in several pages";

  private Dao<T, I> entityDao;
  private Class<T> clazz;
  private ConnectionSource connectionSource;

  /**
   * This class stores the retrieve entities into the Database.
   * 
   * @param connectionSource
   *          Database connection source.
   * @param clazz
   *          Entity class.
   * @throws SQLException
   *           In case of error.
   */
  public JiraEntityMiner(Class<T> clazz, ConnectionSource connectionSource) throws SQLException {
    this.entityDao = DaoManager.createDao(connectionSource, clazz);
    this.clazz = clazz;
    this.connectionSource = connectionSource;
  }

  /**
   * Writes the contents of a ResponseList to a Database.
   * 
   * @param entityList
   *          Response List.
   * @throws Exception
   *           In case of problems.
   */
  public void writeToDatabase(ResponseList<T> entityList) throws Exception {
    if (entityList != null) {
      enforcePaginationSupport(entityList);
      writeToDatabase(new ArrayList<T>(Arrays.asList(entityList.getValues())));
    }
  }

  /**
   * Writes a List of entities to the Database
   * 
   * @param values
   *          Entity List.
   * @throws Exception
   *           Required by the batch insert procedure.
   */
  public void writeToDatabase(final List<T> values) throws Exception {
    TableUtils.createTableIfNotExists(connectionSource, this.clazz);
    entityDao.callBatchTasks(new Callable<Void>() {

      public Void call() throws Exception {

        for (T entity : values) {
          entityDao.createOrUpdate(entity);
        }

        return null;
      }
    });
  }

  /**
   * Executes a delete looking for an specific value on a table column.
   * 
   * @param columnName
   *          Column name.
   * @param value
   *          Expected value.
   * @throws SQLException
   *           In case of error.
   */
  public void deleteAccordingValue(String columnName, String value) throws SQLException {
    TableUtils.createTableIfNotExists(connectionSource, this.clazz);
    DeleteBuilder<T, I> deleteBuilder = entityDao.deleteBuilder();
    deleteBuilder.where().eq(columnName, value);

    deleteBuilder.delete();
  }

  public Dao<T, I> getEntityDao() {
    return entityDao;
  }

  /**
   * Validates is the response retrieved from the Server comes paginated.
   * 
   * @param responseList
   *          Response List from the Server.
   */
  public void enforcePaginationSupport(ResponseList<?> responseList) {
    if ((responseList.getIsLast() != null && !responseList.getIsLast())
        || responseList.getValues().length < responseList.getTotal()) {
      throw new RuntimeException(
          PAGINATION_ERROR_MSG + ": Is last? " + responseList.getIsLast() + "\n Items in Response: "
              + responseList.getValues().length + "\n Total items: " + responseList.getTotal());
    }
  }
}

package crest.jira.data.retriever.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import crest.jira.data.retriever.map.ResponseList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@DatabaseTable(tableName = "Issue")
public class Issue extends JiraEntity {

  // TODO(cgavidia): Add board field, for those issues without Sprint.

  private static final String SEPARATOR = ";";

  @DatabaseField(foreign = true, columnName = "issueTypeId")
  private IssueType issueType;

  @DatabaseField
  private String boardId;

  @DatabaseField
  private Integer timespent;
  @DatabaseField
  private Integer aggregatetimespent;
  @DatabaseField
  private Date lastViewed;
  @DatabaseField
  private Integer timeestimate;
  @DatabaseField
  private Integer aggregatetimeoriginalestimate;
  @DatabaseField
  private Integer timeoriginalestimate;
  // @DatabaseField
  // TODO(cgavidia): Check this mapping issue. So far, no issue contains this
  // information.
  private Map<String, Object> timetracking;
  @DatabaseField
  private Integer aggregatetimeestimate;
  private Issue[] subtasks;
  private List<SubtaskPerIssue> substasksPerIssue = new ArrayList<SubtaskPerIssue>();

  @DatabaseField
  private String environment;
  @DatabaseField
  private String duedate;
  // @DatabaseField
  // TODO(cgavidia): Check this mapping issue. So far, no issue contains this
  // information.
  private ResponseList<Object> worklog;

  @DatabaseField(foreign = true, columnName = "projectId")
  private Project project;

  private Version[] fixVersions;
  private List<FixVersionPerIssue> fixVersionsPerIssue = new ArrayList<FixVersionPerIssue>();
  private Version[] versions;
  private List<VersionPerIssue> versionsPerIssue = new ArrayList<VersionPerIssue>();

  @DatabaseField(foreign = true, columnName = "resolutionId")
  private Resolution resolution;
  @DatabaseField
  private Date resolutiondate;
  @DatabaseField
  private int workratio;
  // @DatabaseField(foreign = true)
  // TODO(cgavidia): Persist this field. So far, doesn't seem that relevant.
  private Watches watches;
  @DatabaseField
  private Date created;
  @DatabaseField(foreign = true, columnName = "epicId")
  private Epic epic;
  @DatabaseField(foreign = true, columnName = "priorityId")
  private Priority priority;
  private String[] labels;

  @DatabaseField
  private String concatenatedLabels;

  // @DatabaseField(foreign = true)
  // TODO(cgavidia): Again, a many-to-many candidate.
  private IssueLink[] issuelinks;

  @DatabaseField(foreign = true, columnName = "assigneeId")
  private User assignee;
  @DatabaseField(foreign = true, columnName = "creatorId")
  private User creator;
  @DatabaseField(foreign = true, columnName = "reporterId")
  private User reporter;
  @DatabaseField
  private Date updated;
  @DatabaseField(foreign = true, columnName = "statusId")
  private Status status;

  private Component[] components;
  private List<ComponentPerIssue> componentsPerIssue = new ArrayList<ComponentPerIssue>();

  @DatabaseField
  private boolean flagged;
  @DatabaseField
  private String summary;

  // @DatabaseField(foreign = true)
  // TODO(cgavidia): Persist this field. So far, doesn't seem that relevant.
  private Progress aggregateprogress;
  // @DatabaseField(foreign = true)
  private Progress progress;

  private ResponseList<Comment> comment;

  // @DatabaseField(foreign = true)
  // TODO(cgavidia): Persist this field. So far, doesn't seem that relevant.
  private Votes votes;

  // @DatabaseField(foreign = true)
  // TODO(cgavidia): Again, a many-to-many candidate.
  private Sprint[] closedSprints;
  private List<ClosedSprintPerIssue> closedSprintsPerIssue = new ArrayList<ClosedSprintPerIssue>();

  @DatabaseField(foreign = true, columnName = "sprintId")
  private Sprint sprint;

  private ResponseList<History> changeLog;

  public ResponseList<History> getChangeLog() {
    return changeLog;
  }

  /**
   * Assigns the history of changes to an issue. Including the proper
   * configuration of the Issue Id.
   * 
   * @param changeLog
   *          List of changes.
   */
  public void setChangeLog(ResponseList<History> changeLog) {
    this.changeLog = changeLog;

    for (History history : changeLog.getValues()) {
      history.setIssueId(this.getId());
    }
  }

  public Sprint getSprint() {
    return sprint;
  }

  public void setSprint(Sprint sprint) {
    this.sprint = sprint;
  }

  public Sprint[] getClosedSprints() {
    return closedSprints;
  }

  /**
   * Assigns a group of Closed Sprints for an Issue.
   * 
   * @param closedSprints
   *          Group of Closed Sprints.
   */
  public void setClosedSprints(Sprint[] closedSprints) {
    this.closedSprints = closedSprints;

    if (closedSprints != null && closedSprints.length > 0) {
      for (Sprint theSprint : closedSprints) {
        ClosedSprintPerIssue closedSprint = new ClosedSprintPerIssue(this, theSprint);
        this.closedSprintsPerIssue.add(closedSprint);
      }
    }
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public User getAssignee() {
    return assignee;
  }

  public void setAssignee(User assignee) {
    this.assignee = assignee;
  }

  public IssueType getIssueType() {
    return issueType;
  }

  public void setIssueType(IssueType issueType) {
    this.issueType = issueType;
  }

  public Integer getTimespent() {
    return timespent;
  }

  public void setTimespent(Integer timeSpent) {
    this.timespent = timeSpent;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Version[] getFixVersions() {
    return fixVersions;
  }

  /**
   * Associates fix versions to this issue.
   * 
   * @param fixVersions
   *          Fix versions.
   */
  public void setFixVersions(Version[] fixVersions) {
    this.fixVersions = fixVersions;

    if (fixVersions != null && fixVersions.length > 0) {
      for (Version theVersion : fixVersions) {
        FixVersionPerIssue fixVersionPerIssue = new FixVersionPerIssue(this, theVersion);
        fixVersionsPerIssue.add(fixVersionPerIssue);
      }
    }
  }

  public Integer getAggregatetimespent() {
    return aggregatetimespent;
  }

  public void setAggregatetimespent(Integer aggregatetimespent) {
    this.aggregatetimespent = aggregatetimespent;
  }

  public Resolution getResolution() {
    return resolution;
  }

  public void setResolution(Resolution resolution) {
    this.resolution = resolution;
  }

  public Date getResolutiondate() {
    return resolutiondate;
  }

  public void setResolutiondate(Date resolutiondate) {
    this.resolutiondate = resolutiondate;
  }

  public int getWorkratio() {
    return workratio;
  }

  public void setWorkratio(int workratio) {
    this.workratio = workratio;
  }

  public Date getLastViewed() {
    return lastViewed;
  }

  public void setLastViewed(Date lastViewed) {
    this.lastViewed = lastViewed;
  }

  public Watches getWatches() {
    return watches;
  }

  public void setWatches(Watches watches) {
    this.watches = watches;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Epic getEpic() {
    return epic;
  }

  public void setEpic(Epic epic) {
    this.epic = epic;
  }

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public String[] getLabels() {
    return labels;
  }

  /**
   * Assigns a group of labels of this Issue. It also prepares the information
   * for storage.
   * 
   * @param labels
   *          Group of labels.
   */
  public void setLabels(String[] labels) {
    this.labels = labels;

    this.concatenatedLabels = "";
    for (String oneLabel : labels) {
      this.concatenatedLabels += oneLabel + SEPARATOR;
    }
  }

  public Integer getTimeestimate() {
    return timeestimate;
  }

  public void setTimeestimate(Integer timeestimate) {
    this.timeestimate = timeestimate;
  }

  public Integer getAggregatetimeoriginalestimate() {
    return aggregatetimeoriginalestimate;
  }

  public void setAggregatetimeoriginalestimate(Integer aggregatetimeoriginalestimate) {
    this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
  }

  public Version[] getVersions() {
    return versions;
  }

  /**
   * Configures a set of versions for an Issue.
   * 
   * @param versions
   *          Set of versions.
   */
  public void setVersions(Version[] versions) {
    this.versions = versions;

    if (versions != null && versions.length > 0) {
      for (Version theVersion : versions) {
        VersionPerIssue versionPerIssue = new VersionPerIssue(this, theVersion);
        this.versionsPerIssue.add(versionPerIssue);
      }
    }
  }

  public IssueLink[] getIssuelinks() {
    return issuelinks;
  }

  public void setIssuelinks(IssueLink[] issuelink) {
    this.issuelinks = issuelink;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public Component[] getComponents() {
    return components;
  }

  /**
   * Configures the set of components related to an Issue.
   * 
   * @param components
   *          Component list.
   */
  public void setComponents(Component[] components) {
    this.components = components;

    if (components != null && components.length > 0) {
      for (Component theComponent : components) {
        ComponentPerIssue componentPerIssue = new ComponentPerIssue(theComponent, this);
        this.componentsPerIssue.add(componentPerIssue);
      }
    }

  }

  public Integer getTimeoriginalestimate() {
    return timeoriginalestimate;
  }

  public void setTimeoriginalestimate(Integer timeoriginalestimate) {
    this.timeoriginalestimate = timeoriginalestimate;
  }

  public Map<String, Object> getTimetracking() {
    return timetracking;
  }

  public void setTimetracking(Map<String, Object> timetracking) {
    this.timetracking = timetracking;
  }

  public Integer getAggregatetimeestimate() {
    return aggregatetimeestimate;
  }

  public void setAggregatetimeestimate(Integer aggregatetimeestimate) {
    this.aggregatetimeestimate = aggregatetimeestimate;
  }

  public boolean getFlagged() {
    return flagged;
  }

  public void setFlagged(boolean flagged) {
    this.flagged = flagged;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  public Issue[] getSubtasks() {
    return subtasks;
  }

  /**
   * Assigns a list of issues as Subtasks.
   * 
   * @param subtasks
   *          List of subtasks.
   */
  public void setSubtasks(Issue[] subtasks) {
    this.subtasks = subtasks;

    if (subtasks != null && subtasks.length > 0) {
      for (Issue subtask : subtasks) {
        SubtaskPerIssue subtaskPerIssue = new SubtaskPerIssue(this, subtask);
        this.substasksPerIssue.add(subtaskPerIssue);
      }
    }
  }

  public User getReporter() {
    return reporter;
  }

  public void setReporter(User reporter) {
    this.reporter = reporter;
  }

  public Progress getAggregateprogress() {
    return aggregateprogress;
  }

  public void setAggregateprogress(Progress aggregateprogress) {
    this.aggregateprogress = aggregateprogress;
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }

  public String getDuedate() {
    return duedate;
  }

  public void setDuedate(String duedate) {
    this.duedate = duedate;
  }

  public Progress getProgress() {
    return progress;
  }

  public void setProgress(Progress progress) {
    this.progress = progress;
  }

  public ResponseList<Comment> getComment() {
    return comment;
  }

  /**
   * Assigns a list of comments to this issue. It includes setting the proper
   * IssueId to each comment.
   * 
   * @param comments
   *          List of Comments as a Response List.
   */
  public void setComment(ResponseList<Comment> comments) {

    for (Comment comment : comments.getValues()) {
      comment.setIssueId(this.getId());
    }
    this.comment = comments;
  }

  public Votes getVotes() {
    return votes;
  }

  public void setVotes(Votes votes) {
    this.votes = votes;
  }

  public ResponseList<Object> getWorklog() {
    return worklog;
  }

  public void setWorklog(ResponseList<Object> worklog) {
    this.worklog = worklog;
  }

  public String getConcatenatedLabels() {
    return concatenatedLabels;
  }

  public void setConcatenatedLabels(String concatenatedLabels) {
    this.concatenatedLabels = concatenatedLabels;
  }

  public List<ComponentPerIssue> getComponentsPerIssue() {
    return componentsPerIssue;
  }

  public void setComponentsPerIssue(List<ComponentPerIssue> componentsPerIssue) {
    this.componentsPerIssue = componentsPerIssue;
  }

  public List<SubtaskPerIssue> getSubstasksPerIssue() {
    return substasksPerIssue;
  }

  public void setSubstasksPerIssue(List<SubtaskPerIssue> substasksPerIssue) {
    this.substasksPerIssue = substasksPerIssue;
  }

  public List<FixVersionPerIssue> getFixVersionsPerIssue() {
    return fixVersionsPerIssue;
  }

  public void setFixVersionsPerIssue(List<FixVersionPerIssue> fixVersionsPerIssue) {
    this.fixVersionsPerIssue = fixVersionsPerIssue;
  }

  public List<VersionPerIssue> getVersionsPerIssue() {
    return versionsPerIssue;
  }

  public void setVersionsPerIssue(List<VersionPerIssue> versionsPerIssue) {
    this.versionsPerIssue = versionsPerIssue;
  }

  public List<ClosedSprintPerIssue> getClosedSprintsPerIssue() {
    return closedSprintsPerIssue;
  }

  public void setClosedSprintsPerIssue(List<ClosedSprintPerIssue> closedSprintsPerIssue) {
    this.closedSprintsPerIssue = closedSprintsPerIssue;
  }

  public String getBoardId() {
    return boardId;
  }

  public void setBoardId(String boardId) {
    this.boardId = boardId;
  }

}
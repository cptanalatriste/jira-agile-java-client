package crest.jira.data.retriever.model;

import java.util.Date;

public class Issue extends JiraEntity {

  private IssueType issueType;

  // TODO(cgavidia): Add a proper type.
  private String timespent;
  private String aggregatetimespent;
  private Date lastViewed;
  private String timeestimate;
  private String aggregatetimeoriginalestimate;
  private String timeoriginalestimate;
  private Object timetracking;
  private String aggregatetimeestimate;
  private Object subtasks;
  private String environment;
  private String duedate;
  private Object[] worklog;

  private Project project;
  private Version[] fixVersions;
  private Resolution resolution;
  private Date resolutiondate;
  private int workratio;
  private Watches watches;
  private Date created;
  private Epic epic;
  private Priority priority;
  private String[] labels;
  private Version[] versions;
  private IssueLink[] issuelinks;
  private User assignee;
  private Date updated;
  private Status status;
  private Component[] components;
  private boolean flagged;
  private String summary;
  private User creator;
  private User reporter;
  private Progress aggregateprogress;
  private Progress progress;
  private Comment[] comment;
  private Votes votes;
  private Sprint[] closedSprints;
  private Sprint sprint;

  private History[] changeLog;

  public History[] getChangeLog() {
    return changeLog;
  }

  public void setChangeLog(History[] changeLog) {
    this.changeLog = changeLog;
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

  public void setClosedSprints(Sprint[] closedSprints) {
    this.closedSprints = closedSprints;
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

  public String getTimespent() {
    return timespent;
  }

  public void setTimespent(String timeSpent) {
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

  public void setFixVersions(Version[] fixVersions) {
    this.fixVersions = fixVersions;
  }

  public String getAggregatetimespent() {
    return aggregatetimespent;
  }

  public void setAggregatetimespent(String aggregatetimespent) {
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

  public void setLabels(String[] labels) {
    this.labels = labels;
  }

  public String getTimeestimate() {
    return timeestimate;
  }

  public void setTimeestimate(String timeestimate) {
    this.timeestimate = timeestimate;
  }

  public String getAggregatetimeoriginalestimate() {
    return aggregatetimeoriginalestimate;
  }

  public void setAggregatetimeoriginalestimate(String aggregatetimeoriginalestimate) {
    this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
  }

  public Version[] getVersions() {
    return versions;
  }

  public void setVersions(Version[] versions) {
    this.versions = versions;
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

  public void setComponents(Component[] components) {
    this.components = components;
  }

  public String getTimeoriginalestimate() {
    return timeoriginalestimate;
  }

  public void setTimeoriginalestimate(String timeoriginalestimate) {
    this.timeoriginalestimate = timeoriginalestimate;
  }

  public Object getTimetracking() {
    return timetracking;
  }

  public void setTimetracking(Object timetracking) {
    this.timetracking = timetracking;
  }

  public String getAggregatetimeestimate() {
    return aggregatetimeestimate;
  }

  public void setAggregatetimeestimate(String aggregatetimeestimate) {
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

  public Object getSubtasks() {
    return subtasks;
  }

  public void setSubtasks(Object subtasks) {
    this.subtasks = subtasks;
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

  public Comment[] getComment() {
    return comment;
  }

  public void setComment(Comment[] comment) {
    this.comment = comment;
  }

  public Votes getVotes() {
    return votes;
  }

  public void setVotes(Votes votes) {
    this.votes = votes;
  }

  public Object[] getWorklog() {
    return worklog;
  }

  public void setWorklog(Object[] worklog) {
    this.worklog = worklog;
  }
}
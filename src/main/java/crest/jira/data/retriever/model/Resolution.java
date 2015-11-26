package crest.jira.data.retriever.model;

import com.j256.ormlite.table.DatabaseTable;

/**
 * An issue can be resolved in many ways, only one of them being 'Fixed'. A
 * resolution is usually set when the status is changed.
 * 
 * <li>Fixed — A fix for this issue has been implemented.
 * <li>Won't Fix — This issue will not be fixed.
 * <li>Duplicate — This issue is a duplicate of an existing issue.
 * <li>Incomplete — There is not enough information to work on this issue.
 * <li>Cannot Reproduce — This issue could not be reproduced at this time, or
 * not enough information was available to reproduce the issue.
 * <li>Won't Do — This issue won't be actioned.
 * 
 * @see <a href=
 *      "https://confluence.atlassian.com/jira/what-is-an-issue-270829373.html">
 *      What is an Issue, from JIRA User's Guide </a>
 * 
 * @author Carlos G. Gavidia
 */
@DatabaseTable(tableName = "Resolution")
public class Resolution extends JiraEntity {

}

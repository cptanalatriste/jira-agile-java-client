package crest.jira.data.retriever;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class JiraRestClientTest extends TestCase {

  /**
   * Create the test case.
   *
   * @param testName
   *          name of the test case
   */
  public JiraRestClientTest(String testName) {
    super(testName);
  }

  /**
   * the suite of tests being tested
   * 
   * @return The test suite.
   */
  public static Test suite() {
    return new TestSuite(JiraRestClientTest.class);
  }

  /**
   * Rigourous Test.
   */
  public void testApp() {
    assertTrue(true);
  }
}

package CucumberOptionsss;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;



public class TestJiraListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			BasicCredentials creds = new BasicCredentials("protestcorp@gmail.com","01I5Ee5aLHS7W7e8aPz671C1");
			JiraClient jira = new JiraClient("https://protescorp123.atlassian.net/", creds);
			try {
			 jira.createIssue("JIR", "Bug").field(Field.SUMMARY,result.getMethod().getMethodName() +"is failed due to: "+ result.getThrowable().toString()).field(Field.DESCRIPTION, "get the description").execute();
			} catch (JiraException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Issue is creted in jira with issue key: "+createIssue.getKey());
		}

	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
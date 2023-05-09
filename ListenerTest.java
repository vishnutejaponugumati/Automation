package com.test.automation.uiAutomation.testBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("The name of the testcase Started is :"+result.getName());
 String methodname = result.getName();
 //getScreenShot(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("The name of the testcase Passed is :"+result.getName());

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("The name of the testcase failed is :"+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("The name of the testcase skipped is :"+result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
				
		NotificationEmail2.sendMail();
	}

		
}
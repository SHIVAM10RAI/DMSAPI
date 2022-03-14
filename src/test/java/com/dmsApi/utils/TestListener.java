package com.dmsApi.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.dmsApi.test.BaseTest;

/**
 * @author Shivam Rai 
 * Created Date : 08/03/2022
 */

public class TestListener extends BaseTest implements ITestListener {

	public static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		Logs.info("I am in onStart method " + iTestContext.getName());

	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		Logs.info("I am in onFinish method " + iTestContext.getName());
		// Do tier down operations for ExtentReports reporting!
		ExtentReportManager.getInstance().flush();

	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		Logs.info(getTestMethodName(iTestResult) + " test is starting.");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		Logs.info(getTestMethodName(iTestResult) + " test is succeed.");
		// ExtentReports log operation for passed tests.
		ExtendTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		Logs.info(getTestMethodName(iTestResult) + " test is failed.");

	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		Logs.info(getTestMethodName(iTestResult) + " test is skipped.");
		// ExtentReports log operation for skipped tests.
		ExtendTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		Logs.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
}

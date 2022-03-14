package com.dmsApi.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Shivam Rai
 * Created Date : 08/03/2022
 * 
 */

public class ExtentReportManager {

	private static ExtentReports extent = new ExtentReports();
	private static ExtentSparkReporter reporter;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance

	public static ExtentReports createInstance()

	{
		reporter = new ExtentSparkReporter("./Report/extent-report.html");
		reporter.config().setReportName("API Status Report");
		reporter.config().setDocumentTitle("API REPORT");
		reporter.config().setTheme(Theme.STANDARD);
		//reporter.config().setTheme(Theme.DARK);
		extent.attachReporter(reporter);
		extent.setSystemInfo("Staging-APT-Test", "Staging");
		extent.setSystemInfo("Platform", "QA");
		return extent;
	}

}

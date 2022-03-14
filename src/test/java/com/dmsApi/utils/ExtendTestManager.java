package com.dmsApi.utils;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * @author Shivam Rai Created Date : 08/03/2022
 *
 */

public class ExtendTestManager {

	public static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
	public static ExtentReports extent = ExtentReportManager.createInstance();

	public static synchronized ExtentTest getTest() {

		return extentTestMap.get((int) Thread.currentThread().getId());
	}

	// Created synchronized ExtentTest method of createTest

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.createTest(testName, desc);
		extentTestMap.put((int) Thread.currentThread().getId(), test);
		return test;
	}

}

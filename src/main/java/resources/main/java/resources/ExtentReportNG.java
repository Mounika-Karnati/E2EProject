package main.java.resources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	public static ExtentReports extent;

	public static ExtentReports config() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Result");
		report.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Mounika");
		return extent;
	}

}

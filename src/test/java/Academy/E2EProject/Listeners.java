package test.java.Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import main.java.Academy.E2EProject.Base;
import main.java.resources.ExtentReportNG;

//itestlistner is an interface implements testng listeners
public class Listeners extends Base implements ITestListener {
	ExtentReports extent=ExtentReportNG.config();
	public ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Working as expected");
		System.out.println("Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		extentTest.get().fail(result.getThrowable());
		String testmethodname=result.getMethod().getMethodName();
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	
	try {
		extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testmethodname,driver), result.getMethod().getMethodName());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}

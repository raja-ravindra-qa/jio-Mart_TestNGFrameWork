package abstractcomponent;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends baseclass implements ITestListener{
	ExtentTest test;
	ExtentReports extent =baseclass.extentconfig();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test =extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		test.log(Status.PASS, "it is fine, Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String path = null;
	
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		test.fail(result.getThrowable());
		try {
			path=takescreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());	
		// System.out.println());
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
		// TODO Auto-generated method stub
//		System.out.println("hello dude extent.flush is here, have you came here");
		extent.flush();
	}
	

}

package EndtoEndFrameWork;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.extentReports;


public class Listeners extends Base implements ITestListener {

	
	ExtentReports report=extentReports.getReports();
	
	ExtentTest test;
	String testMethodName;
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result){
		
		String methodName=result.getMethod().getMethodName();
		test=report.createTest(methodName);
		extentTest.set(test);
		
		
        
		
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS,"Test got Passed");

	}

	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		testMethodName=result.getMethod().getMethodName();
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName,driver));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		extentTest.get().fail(result.getThrowable());
		

        

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		 
		report.flush();

	}

}

package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListeners implements ITestListener {
	public static ExtentTest test;
	static ExtentReports report;
	static WebDriver driver=DriverInit.driver;
	@Override
	public void onFinish(ITestContext result) {
		report.endTest(test);
		report.flush();
		
	}

	@Override
	public void onStart(ITestContext result) {
		report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\"+result.getSuite().getName()+"_Report.html");
		report.loadConfig(new File (System.getProperty("user.dir")+"\\Reports\\config.xml"));
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
			try {
			
			Functions.takescreenshot(result.getName());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL,result.getInstanceName()+" : "+result.getName()+" -- FAILED",test.addScreenCapture(System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+"fail.png"));
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		test.log(LogStatus.SKIP,result.getInstanceName()+" : "+result.getName()+" -- SKIPPED");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.startTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(LogStatus.PASS,result.getInstanceName()+" : "+result.getName()+" -- PASSED");
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

}

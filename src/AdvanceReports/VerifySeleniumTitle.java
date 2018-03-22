package AdvanceReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class VerifySeleniumTitle {
	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	
	@Test
	public void verifyBlogTitle(){
		
		report = new ExtentReports("C:\\Report\\learnAutomation.html");
		report.startTest("Test1VerifyBlogTitle");
				
		driver=new FirefoxDriver();
		logger.log(LogStatus.INFO, "Browser started");
		
		driver.get("http://learn-automation.com");
		
		logger.log(LogStatus.INFO, "Application is up and running");
		String title = driver.getTitle();
		
		Assert.assertTrue(title.contains("Selenium"));
		
		logger.log(LogStatus.PASS, "Title verified");
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			String screenshot_path = Utility.captureScreenShot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification", image);
			
		}
		
		report.endTest(logger);
		report.flush();
		
		driver.get("C:\\Report\\learnAutomation.html");
		
	}
	
}

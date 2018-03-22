package AdvanceReports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utility {
	
	
	public static String captureScreenShot(WebDriver driver, String screenShotName) {
		
		try{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = "C:\\Users\\sai\\Desktop\\workspace\\SeleniumSessions\\Screenshots"+screenShotName+".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken");
			
			return dest; //returns screenshot path
		}
		catch(Exception e){
			
			System.out.println("Exception while taking screenshot "+e.getMessage());
			return e.getMessage();
		}
		
		
		
		
	}

}

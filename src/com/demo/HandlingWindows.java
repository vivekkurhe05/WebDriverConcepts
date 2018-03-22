package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingWindows {

	public static void main(String[] args) throws Exception {
		
		Properties prop = new Properties();
		InputStream is = new FileInputStream("C:/Users/sai/Desktop"
				+ "/workspace/SeleniumSessions/handlingWindows.properties");
		
		prop.load(is);
		
		Logger logger = Logger.getLogger("HandlingWindows");
		PropertyConfigurator.configure("Log4j.properties");
		
				
		System.setProperty(prop.getProperty("gckodriver"), prop.getProperty("geckodriver_exe_path"));
		logger.info("Gecko driver is setting up");
		
		WebDriver driver = new FirefoxDriver();
		logger.info("Firefox is launching");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		logger.info("Waiting for page load timeout for 20 sec");
		
		driver.get(prop.getProperty("URL"));
		logger.info("URL is opened http://toolsqa.com/automation-practice-switch-windows/");
		
		logger.info("Sleeping for 1 second");
		Thread.sleep(1000);
		
		
		driver.findElement(By.id(prop.getProperty("newBrowserWindowBtn"))).click();
		logger.info("Clicked on New Window button");
		
		String parent_window = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		
		for(String s1 : childWindow){
			if(!s1.equals(parent_window)){
				driver.switchTo().window(s1);
				logger.info("Switched to child window");
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("Title is======"+driver.getTitle());
				if(driver.getTitle().contains("QA Automation Tools")){
					logger.info("New window title is read");
				}
				else{
					logger.error("New Browser window title is not read");
				}
				
			}
			
		}
		driver.switchTo().window(parent_window);
		
		if(driver.getTitle().contains("A new title")){
			logger.info("Switched to Main window  and title is read");
		}
		else{
			logger.error("Wrong title is read");
		}
		
		
		System.out.println(driver.getTitle());
		
		
	}

}

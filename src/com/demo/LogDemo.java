package com.demo;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogDemo {
	
	static WebDriver driver;
	static JavascriptExecutor js;
	static WebElement element;
	static String photoUrl;


	public static void main(String[] args) throws InterruptedException {
		
		Logger logger = Logger.getLogger("LogDemo");
		PropertyConfigurator.configure("Log4j.properties");
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");

		driver=new FirefoxDriver();
		logger.info("Firefox opened");
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		logger.info("URL entered and application launched");
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		
		js=(JavascriptExecutor)driver;
		element=driver.findElement(By.id("photo"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		logger.info("Script is executed");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		photoUrl="C:\\Users\\sai\\Desktop\\my photo\\200vivek.jpg";
//		photoUrl="C:\\Users\\sai\\Desktop\\ISTQB_papers\\istqbExamCertification.com-ISTQB-Dumps-and-Mock-Tests-for-Foundation-Level-Paper-1.pdf";
		driver.findElement(By.xpath("//*[@id='photo']")).sendKeys(photoUrl);
		logger.info("photo uploaded");
		Thread.sleep(2000);
		driver.quit();
		logger.info("Browser quit");
		
	}

}

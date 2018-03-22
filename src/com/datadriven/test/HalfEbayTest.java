package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader1;
import com.test.utility.TestUtil;

public class HalfEbayTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sai\\workspace\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=http%3A%2F%2Fpages.ebay.com%2Fmessages%2Fpage_not_found.html");
				
	}
	
	@Test(dataProvider = "getTestData")
	public void halfEbayRegPageTest(String firstName, String lastName, String emailAddress, String password){
		
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='suggestion']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='suggestion']")).sendKeys(emailAddress);
		driver.findElement(By.id("PASSWORD")).sendKeys(password);

	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		Iterator<Object[]> it= testData.iterator();
		return it;
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}

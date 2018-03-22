package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excel.utility.Xls_Reader1;

public class ParameterizeTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sai\\workspace\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=http%3A%2F%2Fpages.ebay.com%2Fmessages%2Fpage_not_found.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Xls_Reader1 reader = new Xls_Reader1("C:\\Users\\sai\\Desktop\\workspace\\SeleniumSessions\\src\\com\\testdata\\HalfEbayTestData.xlsx");
		int rowCount = reader.getRowCount("RegTestData");
		
		reader.addColumn("RegTestData", "Status");
		
		for(int i=2; i<=rowCount;i++){
			
			String firstName = reader.getCellData("RegTestData", "firstname", i);
			String lastName = reader.getCellData("RegTestData", "lastname", i);
			String emailAddress = reader.getCellData("RegTestData", "emailaddress", i);
			String password = reader.getCellData("RegTestData", "password", i);
			
			System.out.println(firstName);
			System.out.println(lastName);
			System.out.println(emailAddress);
			System.out.println(password);
			System.out.println("\n");
						
			driver.findElement(By.id("firstname")).sendKeys(firstName);
			driver.findElement(By.id("lastname")).sendKeys(lastName);
			driver.findElement(By.xpath("//input[@id='suggestion']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@id='suggestion']")).sendKeys(emailAddress);
			driver.findElement(By.id("PASSWORD")).sendKeys(password);
			
			driver.findElement(By.id("firstname")).clear();
			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.xpath("//input[@id='suggestion']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@id='suggestion']")).sendKeys(Keys.DELETE);
			driver.findElement(By.id("PASSWORD")).clear();
			
			
			reader.setCellData("RegTestData", "Status", i, "Pass"); //write the data into cell

			Thread.sleep(2000);
//			driver.quit();

			

			
		}

		
	}

}

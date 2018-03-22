package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excel.utility.Xls_Reader1;

public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sai\\workspace\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=http%3A%2F%2Fpages.ebay.com%2Fmessages%2Fpage_not_found.html");

		Xls_Reader1 reader = new Xls_Reader1("C:\\Users\\sai\\Desktop\\workspace\\SeleniumSessions\\src\\com\\testdata\\HalfEbayTestData.xlsx");



		String firstname = reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);

		String lastname = reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);

		String emailaddress = reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(emailaddress);

		String password = reader.getCellData("RegTestData", "password", 2);
		System.out.println(password);

		int rowcount=reader.getRowCount("RegTestData");
		System.out.println("Total rows are "+(rowcount-1));



		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='suggestion']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='suggestion']")).sendKeys(emailaddress);
		driver.findElement(By.id("PASSWORD")).sendKeys(password);

		Thread.sleep(2000);
		driver.quit();



	}

}

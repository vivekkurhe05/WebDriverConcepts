package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-table");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String tdata=driver.findElement(By.xpath("//table[@summary='Sample Table']")).getText();
		System.out.println(tdata);
		
		for(int i=0;i<80;i++)
			System.out.print("=");
		System.out.println("\n");
		
		String text1=driver.findElement(By.xpath("//table[@summary='Sample Table']//td[text()='Saudi Arabia']/following-sibling::td/a[text()='details']")).getText();
		System.out.println(text1);
		
		String text2=driver.findElement(By.xpath("//table[@summary='Sample Table']//td[text()='China']/preceding-sibling::th")).getText();
		System.out.println(text2);
		
		String text3=driver.findElement(By.xpath("//table[@summary='Sample Table']//td[text()='Taiwan']/following::td//a[text()='details']")).getText();
		System.out.println(text3);
		
		String text4=driver.findElement(By.xpath("//table[@summary='Sample Table']//td[text()='China']/preceding::th")).getText();
		System.out.println(text4);
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}

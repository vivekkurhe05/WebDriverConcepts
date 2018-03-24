package com.demo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetBrowserWidthHeight {

	static WebDriver driver;
	static Dimension d1,d2;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		d1 = driver.manage().window().getSize();
		System.out.println(d1.toString());
		
		Thread.sleep(2000);
		d2= new Dimension(200,400);
		driver.manage().window().setSize(d2);
		

		
		
	}

}

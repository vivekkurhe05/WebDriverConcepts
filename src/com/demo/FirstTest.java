package com.demo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstTest {

	public static void main(String[] args) throws MalformedURLException {
		
//		System.setProperty("webdriver.chrome.driver", "C:/Users/sai/Downloads/selenium setup/chromedriver_win32/chromedriver.exe");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--test-type");
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		WebDriver driver=new ChromeDriver(options);
//		driver.get("https://www.google.com");
//		driver.manage().window().maximize();
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/sai/Downloads/selenium setup/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("selenium");
		driver.findElement(By.name("pass")).sendKeys("webdriver");
		
	}

}

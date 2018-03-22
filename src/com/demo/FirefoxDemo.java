package com.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirefoxDemo {

	static WebDriver driver;
	static String url, pageUrl;
	static WebElement day, month, year;
	static int days_count, months_count, years_count;
	
	public static void main(String[] args) {

		
		System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("Vivek.kurhe");
		driver.findElement(By.id("pass")).sendKeys("abc");
		String facebookTitle=driver.getTitle();
		System.out.println("Facebook login page title : "+facebookTitle);
		url=driver.getCurrentUrl();
		pageUrl = "https://www.facebook.com/";
		if(url.equals(pageUrl)){
			System.out.println("Valid URL");
		}
		else{
			System.out.println("Invalid URL");
		}
		
		Select opt1=new Select(driver.findElement(By.id("day")));
		day=opt1.getFirstSelectedOption();
		System.out.println("Day is "+day.getText());
		List<WebElement> all_opt1=opt1.getOptions();
		days_count=all_opt1.size()-1;
		System.out.println("Total days are "+days_count);
		for(WebElement ele:all_opt1){
			if(ele.getText().equals("Day"))
				continue;
			else
				System.out.println(ele.getText());
		}
		
		
		Select opt2=new Select(driver.findElement(By.id("month")));
		month=opt2.getFirstSelectedOption();
		System.out.println("Month is "+month.getText());
		List<WebElement> all_opt2=opt2.getOptions();
		months_count=all_opt2.size()-1;
		System.out.println("Total months are "+months_count);
		for(WebElement ele:all_opt2){
			if(ele.getText().equals("Month"))
				continue;
			else
				System.out.println(ele.getText());
			
		}
		
		Select opt3=new Select(driver.findElement(By.id("year")));
		year=opt3.getFirstSelectedOption();
		System.out.println("Year is "+year.getText());
		List<WebElement> all_opt3=opt3.getOptions();
		years_count=all_opt3.size()-1;
		System.out.println("Total years are "+years_count);
		for(WebElement ele:all_opt3){
			if(ele.getText().equals("Year"))
				continue;
			else
				System.out.println(ele.getText());
		}
		
		try{
			driver.close();
		}
		catch(WebDriverException e){
			System.out.println(e.getMessage());
		}
		System.out.println("BYE");
		driver.quit();

	}

}

package com.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/sai/workspace/geckodriver-v0.16.1-win32/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		
		Actions action=new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
		.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).release().build().perform();
		
		
	}

}

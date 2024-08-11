package com.pageobjects;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.testbase.BasePage;

public class Demo  extends BasePage{

	public Demo(WebDriver driver) {
		PageFactory.initElements(driver, this);
         driver=BasePage.driver;
	}
	public void as(String se ) throws Exception {
		
		Thread.sleep(4000);
		//user = (JSONObject)user.get("Inputdata");
		
		WebElement a=	driver.findElement(By.xpath("//div//input[@placeholder='Search']"));
		
		a.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	 se=(String)user.get("key");
		System.out.println(se+"passs");
		
		a.sendKeys(se);
	System.out.println(se+"passs2");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li//a[@href='/web/index.php/pim/viewPimModule']")).click();
	Thread.sleep(3000);
	}
}

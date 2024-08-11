package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.BasePage;

public class Login extends BasePage {
public Login(WebDriver driver) {
	
	PageFactory.initElements( driver,this);
}

@FindBy(xpath="//div//input[@name='username']")
private static WebElement username;

@FindBy(xpath="//div//input[@name='password']")
private static WebElement password;

@FindBy(xpath="//div//button[@type='submit']")
private static WebElement login;

public  void LoginWithUsername() {
	String user_name=prop.getProperty("username");
	String pass=prop.getProperty("password");
	username.sendKeys(user_name);
	password.sendKeys(pass);
	login.click();
}

}

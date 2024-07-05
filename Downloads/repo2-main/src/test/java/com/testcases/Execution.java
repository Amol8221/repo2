package com.testcases;

import org.testng.annotations.Test;
import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pageobjects.Demo;
import com.testbase.BasePage;


@Test(dataProvider="jsondata")
public class Execution  extends BasePage{

	


@Test(groups="group1")
public void run(String b) throws Exception   {
	

	
	Demo d= new Demo(driver);
	//b=(String )user.get("key");
	
	d.as(b);
	System.out.println("passs3");
	
	
}
}


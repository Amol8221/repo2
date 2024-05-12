package com.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testbase.BasePage;

public class ExtentreportManager extends BasePage {

//public static ExtentHtmlReporter htmlreporter;
	public static  ExtentReports reports;
	public static ExtentSparkReporter htmlreporter;
	
	 public EventListener  lis;
		public static ExtentTest test;
	
	
	 
	public static ExtentReports Extentreportgenerated()  {
	 reports= new ExtentReports();
	

		File report=new File("Extentreport.html");
	// File report=new File(System.getProperty(("user.dir")+"/test-output/Extentreport.html"));
		//htmlreporter = new  ExtentHtmlReporter(report);
		htmlreporter=new ExtentSparkReporter(report);
	
		htmlreporter.config().setDocumentTitle("New Project ExtentReport");
		htmlreporter.config().setDocumentTitle("Hybride Demo Framework");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setTimeStampFormat("dd/mm/yyyy h:mm:s");
		reports.attachReporter(htmlreporter);
		//reports.createTest("TC01");
		
		reports.setSystemInfo("Machine","MAC " );
		reports.setSystemInfo("OS","sonoma 14.1.2 " );
		reports.setSystemInfo("browser","Chrome" );
		reports.setSystemInfo("UserName","Amol Ballal" );
		//test.pass("test pass");
		
		
		
		return reports;
}
	
	public static  void Screenshot(String name) throws IOException {
	
		
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String desc=System.getProperty("user.dir")+"/test-output/"+ name +"Screenshots.png";
			FileHandler.copy( src,new File(desc));
			test.addScreenCaptureFromBase64String(desc);
		} catch (NullPointerException e) {
			
		}
	
		    
	
		
		
	}
}
package com.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testbase.BasePage;

public class EventListener extends BasePage   implements ITestListener{


public static ExtentTest test;
public  static XSSFWorkbook book;
public static Logger log=LogManager.getLogger(EventListener.class);
ExtentReports extent=  ExtentreportManager.Extentreportgenerated();
@Override
	public void onTestStart(ITestResult result) {
	
	 
	 String Name=result.getName();
	test=extent.createTest(Name);
log.info(Name);
	
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		String Name=result.getName();
		
		log.info(Name);
		
		 try {
				
				ExtentreportManager.Screenshot(Name);
				test.log(Status.INFO,result.getThrowable());
				test.log(Status.PASS,MarkupHelper.createLabel("Name of Pass test case is: "+result.getName(),ExtentColor.GREEN ));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			 
		}

	
	@Override
	public void onTestFailure(ITestResult result) {

		String Name=result.getName();
		log.info(Name);
		
	
		
//		try {
//			try {
//				driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstanceName());
//			} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchFieldException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//		}
		 
		 try {
			
			ExtentreportManager.Screenshot(Name);
			test.log(Status.INFO,result.getThrowable());
			test.log(Status.FAIL,MarkupHelper.createLabel("Name of Fail test case is: "+result.getName(),ExtentColor.RED ));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		 
	}

		
	
	
		@Override
	public void onTestSkipped(ITestResult result) {
			String Name=result.getName();
			test.log(Status.INFO,result.getThrowable());
			test.log(Status.SKIP,Name+"got Skipped");
			log.info(Name);
			
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}
	@Override
	public void onStart(ITestContext context) {

	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
		
	}


	
 


	
}

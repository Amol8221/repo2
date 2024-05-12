package com.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.JsonObject;
import com.listeners.EventListener;
import com.pageobjects.Login;
import com.utilis.ExcelDataSheet;
import com.utilis.JsonfileReader;





@Listeners({ EventListener.class })
public class BasePage  {

public static     WebDriver driver;

public ExtentTest test;
public static EventListener repo;
public  static Properties prop;
public static ExtentSparkReporter htmlreporter;
public static  ExtentReports reports;
public static Login login;
public static JSONObject user;

public static XSSFSheet book3;
public static final String testDataExcelFileName = "ExcelData.xlsx";
@BeforeMethod(alwaysRun = true)
public  void LaunchApplication() throws InterruptedException {
	BasePage.resfile();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.get(prop.getProperty("url"));
	repo=new EventListener();
     login=new Login(driver);
     Thread.sleep(1000);
     login.LoginWithUsername();
	
   
	

 }
@AfterMethod(alwaysRun = true)
public void closeApplication() {
	driver.quit();
	// repo.flush();
}
@DataProvider(name ="dataprovide")
public Object[][] provider()  {
	return new Object[][] {
		{"search"}
		
		
	
		
	};
}



	
	@DataProvider(name="getExcel_Data")
	public Object[][] getUserRegTestDataFromExcel( )throws InvalidFormatException, IOException {
		return ExcelDataSheet.getTestDataString("ExcelData");
		// System.out.println(data);
		// return data;
	}
	
	
	@DataProvider(name="jsondata")
	public String [] jsondatareader( ) throws Exception{
		return JsonfileReader.jsonreader("Inputdata");
		
	}


public  static void resfile() {

	 prop= new Properties();
	File file=new File(System.getProperty("user.dir")+"/src/main/java/com/resources/config.properites");

	try {
		FileInputStream fis= new FileInputStream(file);
		 prop.load(fis);
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 try {
		if(prop.getProperty("browserName").equalsIgnoreCase("Chrome")) {
			 try {
				driver= new ChromeDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else if(prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
			 try {
				driver=new FirefoxDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}


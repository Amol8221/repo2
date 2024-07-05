package com.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrimeDemo {
 public static void main(String[] args) throws InterruptedException {
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://prime-uat.zopperinsurance.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//div//p[text()='Login with Password']")).click();
		driver.findElement(By.xpath("//div//label/span[text()='Username']")).click();
		driver.findElement(By.xpath("//div//input[@placeholder='Username *']"))
		.sendKeys("+917620580129");
		driver.findElement(By.xpath("//div//input[@placeholder='Password']")).sendKeys("+917620580129");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/button[@type='submit']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='Life']")).click();
		
		Thread.sleep(1000);
		WebElement g=	driver.findElement(By.xpath("(//div//p[text()='First name']/../div/input)[2]"));
		g.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		g.sendKeys("jvdc");
			driver.findElement(By.xpath("(//input[@placeholder='Enter Last Name'])[2]"))
			.sendKeys("selenium");
			
//			driver.findElement(By.xpath("//input[@placeholder='Enter Contact Number']"))
//			.sendKeys("8105155965");
//			
			
			driver.findElement(By.xpath("(//input[@placeholder='Enter Amount (Rs)'])[2]"))
			.sendKeys("30000");
			
			driver.findElement(By.xpath("(//input[@placeholder='Enter Amount'])[2]"))
			.sendKeys("300000");
			Thread.sleep(1000);
			WebElement e=driver.findElement(By.xpath("(//div//input[@placeholder='Enter 6 digit pincode'])[2]"));
		
			e.sendKeys("400001");
			e.sendKeys(Keys.TAB);
			WebElement w= driver.findElement(By.xpath("(//div//select[@class='chakra-select css-1gmqjwm'])[3]"));
			//driver.findElement(By.xpath("//span[@class='chakra-checkbox__control css-l26kmr']"))
			//.click();
			w.click();
	Thread.sleep(1000);
	Select s= new Select(w);
	s.selectByIndex(2);
	
	WebElement w2= driver.findElement(By.xpath("(//div//select[@class='chakra-select css-1gmqjwm'])[4]"));
	//driver.findElement(By.xpath("//span[@class='chakra-checkbox__control css-l26kmr']"))
	//.click();
	w2.click();
Thread.sleep(1000);
Select s2= new Select(w2);
s2.selectByIndex(2);

WebElement w3= driver.findElement(By.xpath("(//div//select[@class='chakra-select css-1gmqjwm'])[5]"));
//driver.findElement(By.xpath("//span[@class='chakra-checkbox__control css-l26kmr']"))
//.click();
w3.click();
Thread.sleep(1000);
Select s3= new Select(w3);
s3.selectByIndex(3);

	
	
	
	System.out.println("pass");
	driver.findElement(By.xpath("//span[@class='chakra-checkbox__control css-l26kmr']"))
	.click();
}
}

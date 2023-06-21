package com.Screenit.version3.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScheduleReportForIAAS {
	
	
	 static  WebDriver driver ;
		
	    @Parameters({"Browser","URL"})
		
		@BeforeTest
		
		public void setup(String Browser , String URL){
			
		
		   if(Browser.equals("chrome"))	{
			   
			   WebDriverManager.chromedriver().setup();
			   
			    driver = new ChromeDriver();
			    
			    Reporter.log("Open chrome browser");
			   
			   
		   }else if(Browser.equals("firefox")){
			   
			   WebDriverManager.firefoxdriver().setup();
			   
			   driver = new FirefoxDriver();
			   
		   }else if (Browser.equals("edge")){
			   
			   WebDriverManager.edgedriver().setup();
			   
			   driver = new EdgeDriver();
			   
			   Reporter.log("Open edge browser");
		   }
		   
		   driver.manage().window().maximize();
		   
		   driver.manage().deleteAllCookies();
		   
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			driver.get(URL);
			
			  Reporter.log("Url should be"+"----"+URL);
			
		}
		
		@Parameters({"Emailid","Password"})
		@Test(priority=1)
		
		public void login(String Emailid , String Password) throws InterruptedException{
			
			
		WebElement user = 	driver.findElement(By.xpath("//input[@id='user_email']")) ;
		
		user.sendKeys(Emailid);
		
		Reporter.log("User Enter the valid Email"+"------"+Emailid);
		
		WebElement pass = 	driver.findElement(By.xpath("//input[@type='password']")) ;
		
		pass.sendKeys(Password);
		
		Reporter.log("User Enter the valid Password"+"------"+Password);
		
		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));
		
		btn.click();
		
		Reporter.log(" User Click the Login button");
		
		Thread.sleep(3000);
		
		String data = driver.getCurrentUrl();

		Assert.assertEquals(data, "https://test.screenit.io/#/dashboard_v3");
		
	    Reporter.log("User should be redirected to the homepage"+"-------"+data);
		
		}
		
		@Test
		
		public void scheduleReportdetails() throws InterruptedException{
			
			Thread.sleep(3000);
			
		WebElement reportbtn = 	driver.findElement(By.xpath("//a[text()='Report ']"));
		
		reportbtn.click();
		
		Thread.sleep(3000);
		
	WebElement  schedulereportbtn  = 	driver.findElement(By.xpath("//a[text()='Interview Report']"));
		
	schedulereportbtn.click();
	
	Thread.sleep(5000);
	
	
	
	
			
		}
		

}

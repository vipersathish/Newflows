package com.Screenit.version3.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.LoginPage;

public class LoginTestForPostiveAndNegativeFlow extends Initializer {

	@BeforeMethod

	public void setUp() throws IOException {

		initialize();
	}

	@Parameters({ "Emailid", "Password" ,"screenshotName"})
	@Test(priority = 1)

	public void loginFunctionality(String Emailid, String Password,String screenshotName) throws InterruptedException {

		
		Thread.sleep(3000);
	 
		driver.get(envprop.getProperty("LOGINURL"));
		
		LoginPage.enterMail(Emailid);
	     
		LoginPage.enterPassword(Password);
		
		LoginPage.clickSigninButton();
		
		Screenshot.Takescrenshots(screenshotName);

		Thread.sleep(3000);
		
		String Url = driver.getCurrentUrl();
		
		Thread.sleep(2000);
		
		if(Url.equals("https://demo.screenit.io/#/dashboard_v3")){
			
			System.out.println("login successfully with valid creditals"+"----"+Url);
			
			Reporter.log("Successfully login with valid creditals and Navigate to the dash board page"+"--------"+Url);
				
		}else{
			
			WebElement data2 = driver.findElement(By.xpath("//p[@class='error-msg']"));
			
			String message = data2.getText();
			
			System.out.println(message);
			
			Assert.assertEquals(message,"Invalid Credentials");
			
			Reporter.log("Successfully enter the wrong creditals getting message from loginpage"+"---"+message);
		}
	
		}
	
	@AfterMethod
	
	
	public void screenShotForFailedTestCase(ITestResult result){
		
	
		if(ITestResult.FAILURE==result.getStatus()){
			
			try{
				
				TakesScreenshot screenshot=(TakesScreenshot)driver;
			
				File src= screenshot.getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(src, new File("C:\\Users\\TTS-USER\\workspace\\com.TestngFramework.ScreenitV3\\FailedLoginPageScreenShots\\"+result.getName()+timestamp()+".png"));
				
				System.out.println("Successfully captured a screenshot");
				
			}catch (Exception e){
				
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
	driver.quit();
	}
	

    public static String timestamp() {
    	
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
	
}

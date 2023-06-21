package com.Screenit.version3.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.SignupPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupTestForPostiveAndNegativeFlow extends Initializer {

	@BeforeMethod

	public void setup() throws IOException {

		initialize();

	}

	@Parameters({ "Emailid", "mobilenumber" ,"screenshotName"})
	@Test

	public void SignUpTestCasesForEmailIdAndMobileNumber(String Emailid, String mobilenumber,String screenshotName)
			throws InterruptedException {

		driver.get(envprop.getProperty("LOGINURL"));

		Thread.sleep(3000);

		SignupPage.clickSignupButton();

		SignupPage.emailField_isDisplayed();

		SignupPage.mobileNumberfield_isdisplayed();

		SignupPage.enterEmail(Emailid);

		SignupPage.enterMobileNumber(mobilenumber);

		SignupPage.EnterSignUpButton();
		
		Screenshot.Takescrenshots(screenshotName);

		Thread.sleep(3000);

		String url = driver.getCurrentUrl();

		System.out.println(url);

		Thread.sleep(3000);

		if (url.equals("https://test.screenit.io/#/registeration/complete")) {

			System.out.println("sign up successfully ");

			Reporter.log("SignUp successfully");

		} else {

			List<WebElement> negtext = driver.findElements(By.tagName("p"));

			for (int i = 0; i < negtext.size(); i++) {

				String data = negtext.get(i).getText();

				if (data.equals("* Enter a valid email")) {

					System.out.println("invalid mail");

					Reporter.log("please check the email" + "-----" + data);

				} else if (data.equals("* Enter valid mobile number")) {

					System.out.println("invalid mobile number");

					Reporter.log("please check the mobile number" + "-----" + data);

				} else if (data.equals("Email or Phone already exist")) {

					System.out.println("already existing mail id");

					Reporter.log(" please check the Already existing mail id and mobile number" + "-----" + data);
				}

			}

		}
	}
	
	@AfterMethod
	
	public void screenShotForFailedTestCase(ITestResult result){
		
		
		if(ITestResult.FAILURE==result.getStatus()){
			
			try{
				
				TakesScreenshot screenshot=(TakesScreenshot)driver;
			
				File src= screenshot.getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(src, new File("C:\\Users\\TTS-USER\\workspace\\com.TestngFramework.ScreenitV3\\FailedSignupPageScreenshots\\"+result.getName()+".png"));
				
				System.out.println("Successfully captured a screenshot");
				
			}catch (Exception e){
				
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
		
	driver.quit();
	}

}

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.CandidateProfilePage;
import com.Screenit.version3.Pages.DashBoardPage;
import com.Screenit.version3.Pages.LoginPage;

public class UploadIdResumeTestForPostiveAndNegativeflow extends Initializer {

	@BeforeTest

	public void setup() throws IOException {

		initialize();
	}

	@Parameters({ "Emailid", "Password", "screenshotName" })
	@Test(priority = 1)

	public void login(String Emailid, String Password, String screenshotName) throws InterruptedException {

		driver.get(envprop.getProperty("LOGINURL"));

		LoginPage.enterMail(Emailid);

		LoginPage.enterPassword(Password);

		LoginPage.clickSigninButton();

		Screenshot.Takescrenshots(screenshotName);

		LoginPage.VerifyNavigateToTheDashBoard();

	}

	@Parameters({ "flow", "file" ,"screenshotName_1"})
	@Test(priority = 2)

	public void UploadSingleResumeWithPostive(String flow, String file,String screenshotName_1) throws InterruptedException {

		DashBoardPage.selectIdOrJd(flow);

		DashBoardPage.clickProfileButton();

		CandidateProfilePage.clickUploadResumeButton();

		CandidateProfilePage.uploadFile(file);

		CandidateProfilePage.clickSubmitButton();
		
		Screenshot.Takescrenshots(screenshotName_1);

		CandidateProfilePage.verifyUploadResumeWithPositiveFlow();

	}

	@Parameters({ "file1","screenshotName_2" })

	@Test(priority = 3)

	public void UploadSingleResumeWithNegative(String file1,String screenshotName_2) throws InterruptedException {

		Thread.sleep(2000);

		DashBoardPage.clickHomeButton();

		DashBoardPage.clickProfileButton();

		CandidateProfilePage.clickUploadResumeButton();

		CandidateProfilePage.uploadFile(file1);

		CandidateProfilePage.clickSubmitButton();
		
		Screenshot.Takescrenshots(screenshotName_2);

		CandidateProfilePage.verifyUploadResumeWithNegativeFlow();

	}
	
	@AfterTest

	public void tearDown(){
			
		
		driver.quit();
		
		}
		
	
}

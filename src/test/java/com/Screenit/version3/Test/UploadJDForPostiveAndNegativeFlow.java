package com.Screenit.version3.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.DashBoardPage;
import com.Screenit.version3.Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadJDForPostiveAndNegativeFlow extends Initializer {

	@BeforeTest

	public void setup() throws IOException {

		initialize();

	}

	@Parameters({ "Emailid", "Password", "screenshotName" })
	@Test(priority = 1)

	public void loginFunctionality(String Emailid, String Password, String screenshotName) throws InterruptedException {

		
		driver.get(envprop.getProperty("LOGINURL"));

		LoginPage.enterMail(Emailid);

		LoginPage.enterPassword(Password);

		LoginPage.clickSigninButton();

		Screenshot.Takescrenshots(screenshotName);

		LoginPage.VerifyNavigateToTheDashBoard();

	}

	@Parameters({ "file" })
	@Test(priority = 2)
	public void uploadJDFile(String file) throws InterruptedException {

		DashBoardPage.clickUploadicon();

		DashBoardPage.clickJDButton();

		DashBoardPage.verifyJDPopUpTittle();

		DashBoardPage.clickUploadButton(file);

		DashBoardPage.clickSubmitButton();
	}

	@Parameters({ "minyear", "maxyear", "primaryskill", "secondaryskill", "location", "minsalary", "maxsalary",
			"vacancy", "jobdescription", "remark" ,"screenshotName_1"})
	@Test(priority = 3)
	public void CreateInterviewerDescriptionJDWithFilledMandatoryField(String minyear, String maxyear,
			String primaryskill, String secondaryskill, String location, String minsalary, String maxsalary,
			String vacancy, String jobdescription, String remark,String screenshotName_1) throws InterruptedException {

		DashBoardPage.verifyPostPopuptitleForJD();

		DashBoardPage.verifyTitleOfThePostForJd();

		DashBoardPage.verifyDateValidity();

		DashBoardPage.SelectMinumumYears(minyear);

		DashBoardPage.SelectMaximumYears(maxyear);

		DashBoardPage.ChoosePrimarySkills(primaryskill);

		DashBoardPage.ChooseSecondarySkills(secondaryskill);

		DashBoardPage.verifyResumeAttachment();

		DashBoardPage.enterJobLoction(location);

		DashBoardPage.enterMinimumSalary(minsalary);

		DashBoardPage.enterMaximumSalary(maxsalary);

		DashBoardPage.enterVacany(vacancy);

		DashBoardPage.EnterJobDescription(jobdescription);

		DashBoardPage.EnterRemark(remark);

		DashBoardPage.clickPostButton();
		
		Screenshot.Takescrenshots(screenshotName_1);

		DashBoardPage.verifyPostCreatedOrNOTForJD();

	}

	@Parameters({ "file" ,"screenshotName_2"})
	@Test(priority=4)

	public void CreateInterviewerDescriptionJDclickResetButtonwithoutfilledMandatoryField(String file,String screenshotName_2)
			throws InterruptedException {

		uploadJDFile(file);

		DashBoardPage.clickResetButton();
		
		DashBoardPage.clickPostButton();
		
       Screenshot.Takescrenshots(screenshotName_2);

		DashBoardPage.verifyPostCreatedOrNOTWithResetButtonForJd();
		
		DashBoardPage.verifyCancelButton();

	}

	@Parameters({ "date","file","title", "minyear", "maxyear", "primaryskill", "secondaryskill", "location", "minsalary", "maxsalary",
			"vacancy", "jobdescription", "remark","screenshotName_3" })
	@Test(priority = 5)
	public void CreateInterviewerDescriptionJDclickResetButtonWithFilledMandatoryField(String date,String file,String title, String minyear,
			String maxyear, String primaryskill, String secondaryskill, String location, String minsalary,
			String maxsalary, String vacancy, String jobdescription, String remark,String screenshotName_3) throws InterruptedException {

		
		uploadJDFile(file);
		
		DashBoardPage.clickResetButton();
		
		DashBoardPage.EnterTheTitle(title);
		
		DashBoardPage.clickDateValidity();

		DashBoardPage.selectDate(date);

		DashBoardPage.clickOkButton();

		DashBoardPage.SelectMinumumYears(minyear);

		DashBoardPage.SelectMaximumYears(maxyear);

		DashBoardPage.ChoosePrimarySkills(primaryskill);

		DashBoardPage.ChooseSecondarySkills(secondaryskill);

		DashBoardPage.enterJobLoction(location);

		DashBoardPage.enterMinimumSalary(minsalary);

		DashBoardPage.enterMaximumSalary(maxsalary);

		DashBoardPage.enterVacany(vacancy);

		DashBoardPage.EnterJobDescription(jobdescription);

		DashBoardPage.EnterRemark(remark);

		DashBoardPage.clickPostButton();
		
		Screenshot.Takescrenshots(screenshotName_3);

		DashBoardPage.verifyPostCreatedOrNOTForJD();

	}
	
	@AfterTest
	
	public void tearDown(){
		
		
		driver.quit();
		
	}

}

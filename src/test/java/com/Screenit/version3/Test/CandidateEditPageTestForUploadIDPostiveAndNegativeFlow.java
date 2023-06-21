package com.Screenit.version3.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.DriverFunctions;
import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.CandidateProfilePage;
import com.Screenit.version3.Pages.DashBoardPage;
import com.Screenit.version3.Pages.LoginPage;

public class CandidateEditPageTestForUploadIDPostiveAndNegativeFlow extends Initializer {

	@BeforeTest

	public static void setUp() throws IOException {

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

	@Parameters({ "flow", "file", "screenshotName_1" })
	@Test(priority = 2)

	public void UploadSingleResume(String flow, String file, String screenshotName_1) throws InterruptedException {

		DashBoardPage.selectIdOrJd(flow);

		DashBoardPage.clickProfileButton();

		CandidateProfilePage.clickUploadResumeButton();

		CandidateProfilePage.uploadFile(file);

		CandidateProfilePage.clickSubmitButton();

		Screenshot.Takescrenshots(screenshotName_1);

		CandidateProfilePage.verifyUploadResumeWithPositiveFlow();

	}

	@Parameters({ "candiname", "candiLastname", "candiMailId", "candiPhoneno", "screenshotName_2" })
	@Test(priority = 3)

	public void CandidateEditProfileWithMandatoryField(String candiname, String candiLastname, String candiMailId, String candiPhoneno,
			String screenshotName_2) throws InterruptedException {

		CandidateProfilePage.clickPostName();

		CandidateProfilePage.clickEditButton();

		CandidateProfilePage.enterCandidateName(candiname);

		CandidateProfilePage.enterCandidateLastName(candiLastname);

		CandidateProfilePage.enterCandidateEmail(candiMailId);

		CandidateProfilePage.enterCandidateMobileNumber(candiPhoneno);

		CandidateProfilePage.clickSaveButton();

		Screenshot.Takescrenshots(screenshotName_2);

		Thread.sleep(4000);

		WebElement canName = DriverFunctions.getElementByXpath("(//a[@class='candidateDetails overflow']//span[@class='canName'])[1]");

		String name = canName.getText();
		
		System.out.println(name);
		
		Thread.sleep(2000);

		WebElement mobilenum = DriverFunctions
				.getElementByXpath("((//a[@class='candidateDetails overflow'])[1]//span)[4]");

		String canmobilenum = mobilenum.getText();
		
	String []  str = 	canmobilenum.split(" ");
	
      String number = 	str[1];
	
	System.out.println(str[1]);
		
		
		
		Thread.sleep(2000);

		WebElement emailid = DriverFunctions
				.getElementByXpath("((//a[@class='candidateDetails overflow'])[1]//span)[7]");

		String candEmailid = emailid.getText();
		
		System.out.println(candEmailid);
	

		if (name.toLowerCase().equals(candiname.toLowerCase())) {

			Reporter.log("Saved Candidate name is successfully dispalyed" + name);
		}

		if (candEmailid.equals(candiMailId)) {

			Reporter.log("Saved candidate email id is successfully displayed");
		}

		if (number.equals(candiPhoneno)) {

			Reporter.log("Saved Candidated phone no is successfully displayed");
		}

		
	}
	
	@Parameters({ "candiname_1", "candiLastname_1", "candiMailId_1", "candiPhoneno_1", "screenshotName_3" })
	@Test(priority = 3)

	public void CandidateEditProfileWithOutFillAllTheField(String candiname_1, String candiLastname_1, String candiMailId_1, String candiPhoneno_1,
			String screenshotName_3) throws InterruptedException {

		CandidateProfilePage.clickPostName();

		CandidateProfilePage.clickEditButton();

		CandidateProfilePage.enterCandidateName(candiname_1);

		CandidateProfilePage.enterCandidateLastName(candiLastname_1);

		CandidateProfilePage.enterCandidateEmail(candiMailId_1);

		CandidateProfilePage.enterCandidateMobileNumber(candiPhoneno_1);

		CandidateProfilePage.clickSaveButton();

		Screenshot.Takescrenshots(screenshotName_3);

		CandidateProfilePage.verifyNegativeMessageForEditCandidate();

	}
	
	@AfterTest
	
	public void tearDown(){
		
		driver.quit();
	}
	
	
}

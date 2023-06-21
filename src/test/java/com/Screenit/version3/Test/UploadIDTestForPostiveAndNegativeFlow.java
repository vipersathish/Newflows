package com.Screenit.version3.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.DriverFunctions;
import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.DashBoardPage;
import com.Screenit.version3.Pages.LoginPage;

public class UploadIDTestForPostiveAndNegativeFlow extends Initializer {

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

	public void UploadIdFile(String file) throws InterruptedException {

		DashBoardPage.clickUploadicon();

		DashBoardPage.clickIDButton();

		DashBoardPage.verifyIDPopUpTittle();

		DashBoardPage.clickUploadButton(file);

		DashBoardPage.clickSubmitButton();

	}

	@Parameters({ "Overallexp", "months", "primaryskill", "secondaryskill", "jobdescription", "remark",
			"screenshotName_1" })
	@Test(priority = 3, description = "When clicking post button with filled the mandatory field")

	public void CreateInterviewerDescriptionIDwithclickPostButtonAndFilledTheMandatoryField(String Overallexp,
			String months, String primaryskill, String secondaryskill, String jobdescription, String remark,
			String screenshotName_1) throws InterruptedException {

		DashBoardPage.verifyPostPopuptitle();

		DashBoardPage.verifyTitleOfThePost();

		DashBoardPage.verifyDateValidity();

		DashBoardPage.SelectOverAllExperience(Overallexp);

		DashBoardPage.SelectMonth(months);

		DashBoardPage.ChoosePrimarySkills(primaryskill);

		DashBoardPage.ChooseSecondarySkills(secondaryskill);

		DashBoardPage.verifyResumeAttachment();

		DashBoardPage.EnterJobDescription(jobdescription);

		DashBoardPage.EnterRemark(remark);

		DashBoardPage.clickPostButton();

		Screenshot.Takescrenshots(screenshotName_1);

		DashBoardPage.verifyPostCreatedOrNOT();

	}

	@Parameters({ "file_1", "Overallexp_1", "months_1", "primaryskill_1", "secondaryskill_1", "jobdescription_1",
			"remark_1", "screenshotName_2" })
	@Test(priority = 4, description = "When clicking the Reset Button without filled the mandatory field")

	public void CreateInterviewerDescriptionIDWithClickResetButtonWithoutFilledAllTheField(String file_1,
			String Overallexp_1, String months_1, String primaryskill_1, String secondaryskill_1,
			String jobdescription_1, String remark_1, String screenshotName_2) throws InterruptedException {

		UploadIdFile(file_1);

		DashBoardPage.verifyPostPopuptitle();

		DashBoardPage.verifyTitleOfThePost();

		DashBoardPage.verifyDateValidity();

		DashBoardPage.SelectOverAllExperience(Overallexp_1);

		DashBoardPage.SelectMonth(months_1);

		DashBoardPage.ChoosePrimarySkills(primaryskill_1);

		DashBoardPage.ChooseSecondarySkills(secondaryskill_1);

		DashBoardPage.verifyResumeAttachment();

		DashBoardPage.EnterJobDescription(jobdescription_1);

		DashBoardPage.EnterRemark(remark_1);

		DashBoardPage.clickResetButton();

		DashBoardPage.clickPostButton();

		Screenshot.Takescrenshots(screenshotName_2);

		DashBoardPage.verifyPostCreatedOrNOTWithResetButton();

		DashBoardPage.verifyCancelButton();

	}

	@Parameters({ "file_2", "Overallexp_2", "months_2", "primaryskill_2", "secondaryskill_2", "jobdescription_2",
			"remark_2", "title", "date", "screenshotName_3" })
	@Test(priority = 5, description = "When clicking the Reset Button with filled all the field and click the Post button")

	public void CreateInterviewerDescriptionIDWithClickResetButtonAndFilledAllTheField(String file_2,
			String Overallexp_2, String months_2, String primaryskill_2, String secondaryskill_2,
			String jobdescription_2, String remark_2, String title, String date, String screenshotName_3)
			throws InterruptedException {

		UploadIdFile(file_2);

		DashBoardPage.verifyPostPopuptitle();

		DashBoardPage.verifyTitleOfThePost();

		DashBoardPage.verifyDateValidity();

		DashBoardPage.SelectOverAllExperience(Overallexp_2);

		DashBoardPage.SelectMonth(months_2);

		DashBoardPage.ChoosePrimarySkills(primaryskill_2);

		DashBoardPage.ChooseSecondarySkills(secondaryskill_2);

		DashBoardPage.verifyResumeAttachment();

		DashBoardPage.EnterJobDescription(jobdescription_2);

		DashBoardPage.EnterRemark(remark_2);

		DashBoardPage.clickResetButton();

		DashBoardPage.EnterTheTitle(title);

		DashBoardPage.clickDateValidity();

		DashBoardPage.selectDate(date);

		DashBoardPage.clickOkButton();

		DashBoardPage.SelectOverAllExperience(Overallexp_2);

		DashBoardPage.SelectMonth(months_2);

		DashBoardPage.ChoosePrimarySkills(primaryskill_2);

		DashBoardPage.ChooseSecondarySkills(secondaryskill_2);

		DashBoardPage.selectAttachment(file_2);

		DashBoardPage.EnterJobDescription(jobdescription_2);

		DashBoardPage.EnterRemark(remark_2);

		DashBoardPage.clickPostButton();

		Screenshot.Takescrenshots(screenshotName_3);

		DashBoardPage.verifyPostCreatedOrNOT();

	}

	@AfterTest

	public void tearDown() {

		driver.quit();

	}

}

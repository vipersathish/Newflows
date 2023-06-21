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

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeclineWithManualScheduleFlowForIAAS extends Initializer {

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

	@Parameters({ "flow", "uploadResumefile", "screenshotName_2" })
	@Test(priority = 4)

	public void UploadSingleResumeWithPostive(String flow, String uploadResumefile, String screenshotName_2)
			throws InterruptedException {

		DashBoardPage.selectIdOrJd(flow);

		DashBoardPage.clickProfileButton();

		CandidateProfilePage.clickUploadResumeButton();

		CandidateProfilePage.uploadFile(uploadResumefile);

		CandidateProfilePage.clickSubmitButton();

		Screenshot.Takescrenshots(screenshotName_2);

		CandidateProfilePage.verifyUploadResumeWithPositiveFlow();

		CandidateProfilePage.checkNewStatus();

	}

	@Parameters({ "interviewername", "date", "time", "sec", "preorsuf", "screenshotName_3" })
	@Test(priority = 5)

	public void SelectSetavailability(String interviewername, String date, String time, String sec, String preorsuf,
			String screenshotName_3) throws InterruptedException {

		CandidateProfilePage.clickSelectInterviewerButton();

		CandidateProfilePage.enterInterviewerNameSearchBox(interviewername);

		CandidateProfilePage.clickEnterInterviewerNameSearchIcon();

		CandidateProfilePage.clickInterviewerSelectButton();

		CandidateProfilePage.clickInterviewerDoneButton();

		CandidateProfilePage.clickSetAvailabilityButton();

		CandidateProfilePage.clickSelectDateButton();

		DashBoardPage.selectDate(date);

		DashBoardPage.clickOkButton();

		DashBoardPage.selectTime(time);

		DashBoardPage.selectSeconds(sec);

		DashBoardPage.selectPreffixOrSuffix(preorsuf);

		DashBoardPage.clickOkButton();

		DashBoardPage.clickSubmitButton();

		Screenshot.Takescrenshots(screenshotName_3);

	}

	@Parameters({ "interviewername_1" })

	@Test(priority = 6)

	public void JavaDeveloperPostStatusWithManualSchedule(String interviewername_1) throws InterruptedException {

		CandidateProfilePage.verifyScheduleRequestPendingstatus();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		CandidateProfilePage.checkSelectedInterviewerList();

		CandidateProfilePage.clickSelectInterviewerButton();
		
		CandidateProfilePage.clickinterviewerUnselectButton();

		CandidateProfilePage.enterInterviewerNameSearchBox(interviewername_1);

		CandidateProfilePage.clickEnterInterviewerNameSearchIcon();

		CandidateProfilePage.clickInterviewerSelectButton();

		CandidateProfilePage.clickInterviewerDoneButton();

		CandidateProfilePage.clickManualScheduleButton();

		CandidateProfilePage.checkSelectedInterviewerList();

		CandidateProfilePage.verifyDeclineStatus();
	}

	@Parameters({ "date_1", "time_1", "sec_1", "preorsuf_1", "screenshotName_33" })
	@Test(priority = 7)

	public void DeclinedStatusAfterSetavailability(String date_1, String time_1, String sec_1, String preorsuf_1,
			String screenshotName_33) throws InterruptedException {

		CandidateProfilePage.clickDeclinewithSetavailability();

		CandidateProfilePage.clickSelectDateButton();

		DashBoardPage.selectAnotherDate(date_1);

		DashBoardPage.clickOkButton();

		DashBoardPage.selectAnotherTime(time_1);

		DashBoardPage.selectAnotherSeconds(sec_1);

		DashBoardPage.selectAnotherPreffixOrSuffix(preorsuf_1);

		DashBoardPage.clickOkButton();

		DashBoardPage.clickSubmitButton();

		Screenshot.Takescrenshots(screenshotName_33);

	}

	@Parameters({ "screenshotName_4", "screenshotName_5", "screenshotName_6", "screenshotName_7", "screenshotName_8",
			"screenshotName_9", "screenshotName_10" })
	@Test(priority = 8)

	public void DeclineStatusAfterScheduleStatus(String screenshotName_4, String screenshotName_5,
			String screenshotName_6, String screenshotName_7, String screenshotName_8, String screenshotName_9,
			String screenshotName_10) throws InterruptedException {

		CandidateProfilePage.verifyScheduleRequestPendingstatus();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_4);

		CandidateProfilePage.checkSelectedInterviewerList();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_5);

		CandidateProfilePage.checkSelectedInterviewerList();

		CandidateProfilePage.clickScheduleTab();

		Screenshot.Takescrenshots(screenshotName_6);

		CandidateProfilePage.verifyScheduleStatus();

		CandidateProfilePage.clickProfileTab();

		Screenshot.Takescrenshots(screenshotName_7);

		CandidateProfilePage.verifyFeedbackPendingStatus();

		CandidateProfilePage.clickFeedbackPendingstatus();

		Screenshot.Takescrenshots(screenshotName_8);

		CandidateProfilePage.viewFeedbackResults();

		CandidateProfilePage.clickViewFeedbackCancelButton();

		Screenshot.Takescrenshots(screenshotName_9);

		CandidateProfilePage.verifySitScoreStatus();

		CandidateProfilePage.verifySelectedOrRejectedStatus();

		Screenshot.Takescrenshots(screenshotName_10);

	}

	@AfterTest

	public void tearDown() {

		driver.quit();
	}

}

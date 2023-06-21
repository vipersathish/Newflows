package com.Screenit.version3.Test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.CandidateProfilePage;
import com.Screenit.version3.Pages.DashBoardPage;
import com.Screenit.version3.Pages.LoginPage;

public class SelectedPanelsAlreadyBlockedForSameTimingFlowForIAAS extends Initializer {
	
	
	
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

	@Parameters({"uploadResumefile_1", "screenshotName_4", "screenshotName_5", "screenshotName_6", "screenshotName_7", "screenshotName_8",
			"screenshotName_9","date", "time", "sec", "preorsuf" })
	@Test(priority = 6)

	public void JavaDeveloperPostStatus(String uploadResumefile_1,String screenshotName_4, String screenshotName_5, String screenshotName_6,
			String screenshotName_7, String screenshotName_8, String screenshotName_9,String date,String time ,String sec,String preorsuf
			) throws InterruptedException {

		CandidateProfilePage.verifyScheduleRequestPendingstatus();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_4);
		
		CandidateProfilePage.checkSelectedInterviewerList();
		
		CandidateProfilePage.clickScheduleTab();

		Screenshot.Takescrenshots(screenshotName_5);

		CandidateProfilePage.verifyScheduleStatus();
		
		CandidateProfilePage.clickUploadResumeButton();

		CandidateProfilePage.uploadFile(uploadResumefile_1);

		CandidateProfilePage.clickSubmitButton();

		Screenshot.Takescrenshots(screenshotName_6);

		CandidateProfilePage.verifyUploadResumeWithPositiveFlow();

		CandidateProfilePage.checkNewStatus();
		
		CandidateProfilePage.clickSetAvailabilityButton();

		CandidateProfilePage.clickSelectDateButton();

		DashBoardPage.selectDate(date);

		DashBoardPage.clickOkButton();

		DashBoardPage.selectTime(time);
		
		DashBoardPage.selectSeconds(sec);
		
		DashBoardPage.selectPreffixOrSuffix(preorsuf);
		
		DashBoardPage.clickOkButton();

		DashBoardPage.clickSubmitButton();

		Screenshot.Takescrenshots(screenshotName_7);
		
		CandidateProfilePage.verifyScheduleRequestPendingstatus();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_8);
		
		CandidateProfilePage.checkSelectedInterviewerList();
		
		Screenshot.Takescrenshots(screenshotName_9);
		
		

	
	}
	

}

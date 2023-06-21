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

public class SelectedAndRejectedAndDeclineAndRescheduleFlowforJd extends Initializer {

	@BeforeTest

	public void setup() throws IOException {

		initialize();

	}

	@Parameters({ "Emailid", "Password", "screenshotName_0" })
	@Test(priority = 1)

	public void loginFunctionality(String Emailid, String Password, String screenshotName_0)
			throws InterruptedException {

		driver.get(envprop.getProperty("LOGINURL"));

		LoginPage.enterMail(Emailid);

		LoginPage.enterPassword(Password);

		LoginPage.clickSigninButton();

		Screenshot.Takescrenshots(screenshotName_0);

		LoginPage.VerifyNavigateToTheDashBoard();

	}

	@Parameters({ "flow", "screenshotName_1", "name", "text", "interviewername", "screenshotName_2", "screenshotName_3",
			"screenshotName_4", "screenshotName_5", "screenshotName_6", "screenshotName_7", "screenshotName_8",
			"screenshotName_9", "screenshotName_10", "screenshotName_11", "screenshotName_12" })
	@Test(priority = 2)

	public void checkProfileMatchedCountAndSelectedFlowForJD(String flow, String screenshotName_1, String name,
			String text, String interviewername, String screenshotName_2, String screenshotName_3,
			String screenshotName_4, String screenshotName_5, String screenshotName_6, String screenshotName_7,
			String screenshotName_8, String screenshotName_9, String screenshotName_10, String screenshotName_11,
			String screenshotName_12) throws InterruptedException {

		DashBoardPage.selectIdOrJd(flow);

		DashBoardPage.clickProfileButton();

		Screenshot.Takescrenshots(screenshotName_1);

		DashBoardPage.verifySitScoreAboveSix();

		CandidateProfilePage.enterSearchByName(name);

		CandidateProfilePage.clickShortlistedButton();

		Screenshot.Takescrenshots(screenshotName_2);

		CandidateProfilePage.verifyShortlistedMessage();

		CandidateProfilePage.clickShortlistedTab();

		Screenshot.Takescrenshots(screenshotName_3);

		CandidateProfilePage.verifyConfirmationPendingStatus();

		CandidateProfilePage.clickShortlistedTab();

		CandidateProfilePage.clickScheduleButtonWithDropdown(text);

		CandidateProfilePage.clickSelectInterviewerWithDropdown(text);

		CandidateProfilePage.enterInterviewerNameSearchBox(interviewername);

		CandidateProfilePage.clickEnterInterviewerNameSearchIcon();

		CandidateProfilePage.clickInterviewerSelectButton();

		CandidateProfilePage.clickInterviewerDoneButton();

		CandidateProfilePage.clickShortlistedTab();

		CandidateProfilePage.clickScheduleButtonWithDropdown(text);

		Screenshot.Takescrenshots(screenshotName_4);

		CandidateProfilePage.verifyScheduleInitiatedStatus();

		CandidateProfilePage.clickShortlistedTabWithRefresh();

		Screenshot.Takescrenshots(screenshotName_5);

		CandidateProfilePage.verifyScheduleRequestPendingstatus();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_6);

		CandidateProfilePage.checkSelectedInterviewerList();

		CandidateProfilePage.clickManualScheduleForJd();

		Screenshot.Takescrenshots(screenshotName_7);

		CandidateProfilePage.verifyScheduleRequestPendingstatus();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_8);

		CandidateProfilePage.checkSelectedInterviewerList();

		CandidateProfilePage.clickScheduleTab();

		Screenshot.Takescrenshots(screenshotName_9);

		CandidateProfilePage.verifyScheduleStatus();

		CandidateProfilePage.clickScheduleTab();

		Screenshot.Takescrenshots(screenshotName_10);

		CandidateProfilePage.verifyFeedbackPendingStatus();

		CandidateProfilePage.clickFeedbackPendingstatus();

		Screenshot.Takescrenshots(screenshotName_11);

		CandidateProfilePage.viewFeedbackResults();

		CandidateProfilePage.clickViewFeedbackCancelButton();

		Screenshot.Takescrenshots(screenshotName_12);

		CandidateProfilePage.clickScheduleTab();

	}

	@Parameters({ "text", "screenshotName_13", "screenshotName_14","screenshotName_144", "screenshotName_15", "screenshotName_16",
			"screenshotName_17", "screenshotName_18", "screenshotName_19", "screenshotName_20"
			})
	@Test(priority = 3)

	public void declinewithSetavailabilityFlow(String text, String screenshotName_13, String screenshotName_14,String screenshotName_144,
			String screenshotName_15, String screenshotName_16, String screenshotName_17, String screenshotName_18,
			String screenshotName_19, String screenshotName_20)
			throws InterruptedException {

		CandidateProfilePage.clickScheduleButtonWithDropdown(text);

		CandidateProfilePage.clickShortlistedTab();

		CandidateProfilePage.verifyScheduleInitiatedStatus();

		CandidateProfilePage.clickShortlistedTabWithRefresh();

		Screenshot.Takescrenshots(screenshotName_13);

		CandidateProfilePage.verifyScheduleRequestPendingstatus();
		
		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_14);

		CandidateProfilePage.checkSelectedInterviewerList();
		
		
		CandidateProfilePage.clickShortlistedTabWithRefresh();
		
		Screenshot.Takescrenshots(screenshotName_144);
		
		CandidateProfilePage.clickManualScheduleForJd();
	
		CandidateProfilePage.verifyScheduleRequestPendingstatus();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_16);

		CandidateProfilePage.checkSelectedInterviewerList();

		CandidateProfilePage.clickShortlistedTabWithRefresh();
		
		CandidateProfilePage.verifyScheduleReInitiatedStatus();

		CandidateProfilePage.clickShortlistedTabWithRefresh();

		Screenshot.Takescrenshots(screenshotName_15);

		CandidateProfilePage.verifyScheduleRequestPendingstatus();

		CandidateProfilePage.clickScheduleRequestPendingStatus();

		Screenshot.Takescrenshots(screenshotName_16);

		CandidateProfilePage.checkSelectedInterviewerList();

		CandidateProfilePage.clickScheduleTab();

		Screenshot.Takescrenshots(screenshotName_17);

		CandidateProfilePage.verifyScheduleStatus();

		CandidateProfilePage.clickScheduleTab();

		Screenshot.Takescrenshots(screenshotName_18);

		CandidateProfilePage.verifyFeedbackPendingStatus();

		CandidateProfilePage.clickFeedbackPendingstatus();

		Screenshot.Takescrenshots(screenshotName_19);

		CandidateProfilePage.viewFeedbackResults();

		CandidateProfilePage.clickViewFeedbackCancelButton();

		Screenshot.Takescrenshots(screenshotName_20);

		CandidateProfilePage.clickScheduleTab();

	}

}

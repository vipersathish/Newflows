package com.Screenit.version3.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.Screenit.version3.Initializer.DriverFunctions;

public class CandidateProfilePage {

	public static void clickUploadResumeButton() {

		try {

			WebElement uploadresumebtn = DriverFunctions.getElementByXpath("//span[text()='Upload Resume']");

			uploadresumebtn.click();

		} catch (Exception e) {

			Reporter.log("upload resume button is not working" + e);
		}

	}

	public static void uploadFile(String file) throws InterruptedException {

		Thread.sleep(2000);

		try {

			DriverFunctions.getElementByXpath("//input[@id='file1']").sendKeys(file);

		} catch (Exception e) {

			Reporter.log("uploadfile is not working" + e);
		}
	}

	public static void clickSubmitButton() throws InterruptedException {

		Thread.sleep(3000);

		try {

			DriverFunctions.getElementByXpath("//button[text()=' Submit ']").click();

		} catch (Exception e) {

			Reporter.log("Submit button is not working" + e);
		}
	}

	public static void verifyUploadResumeWithPositiveFlow() throws InterruptedException {

		try {

			List<WebElement> text = DriverFunctions.getElementsByXpath("//div[@class='awn-bottom-right']");

			for (int i = 0; i < text.size(); i++) {

				String uploadmessage = text.get(i).getText();

				if (uploadmessage.equals("Candidate Resume uploaded successfully")) {

					Reporter.log("Candidate Resume Uploaded Successfully");

					System.out.println("sucess");

				} else {

					Thread.sleep(3000);

					DriverFunctions.getElementByXpath("(//span[text()='×'])[1]").click();

					Reporter.log("Candidate resume already uploaded ");

					System.out.println("already uploaded");
				}

			}

		} catch (Exception e) {

			Reporter.log("Verify positive message is not working " + e);
		}

	}

	public static void verifyUploadResumeWithNegativeFlow() throws InterruptedException {

		Thread.sleep(1000);

		List<WebElement> errormsg = DriverFunctions.getElementsByTagName("p");

		for (int i = 0; i < errormsg.size(); i++) {

			String message = errormsg.get(i).getText();

			if (message.equals("Please upload the file with size <3 MB")) {

				Reporter.log("upload file should be <3mb ");

			} else if (message.equals("Please upload only pdf or doc format")) {

				Reporter.log("upload file should be pdf or docx");

			}

		}

		Thread.sleep(2000);

		WebElement cancelbtn = DriverFunctions.getElementByXpath("(//span[text()='×'])[1]");

		if (cancelbtn.isDisplayed()) {

			cancelbtn.click();

		}

	}

	public static void checkNewStatus() {

		try {
			WebElement firststatus = DriverFunctions.getElementByXpath("//a[text()='New']");

			String data = firststatus.getText();

			Assert.assertEquals(data, "New");

			Reporter.log("The first status should be :" + "----" + data);
		} catch (Exception e) {

			Reporter.log("Status is not working");
		}

	}

	public static void clickOkButton() throws InterruptedException {

		try {
			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//div[text()='Ok']").click();

		} catch (Exception e) {

			Reporter.log("ok button is not working" + e);
		}

	}

	public static void clickPostName() {

		try {

			DriverFunctions.getElementByXpath("(//span[@class='canName'])[2]").click();

		} catch (Exception e) {

			Reporter.log("click post name is not working" + e);

			// TODO: handle exception
		}
	}

	public static void isDisplayed_EditTitle() {

		boolean title = DriverFunctions.getElementByXpath("//h4[text()='Edit Candidate Profile']").isDisplayed();

		if (title == true) {

			Reporter.log("edit candidate title is displayed or not" + "----" + title);
		} else {

			Reporter.log("edit candidate title is not displayed" + "----" + title);
		}
	}

	public static void clickEditButton() {

		DriverFunctions.getElementByXpath("//button[text()='Edit']").click();

	}

	public static void enterCandidateName(String candiname) {

		try {

			WebElement canname = DriverFunctions.getElementByXpath("//input[@placeholder='Name*']");

			canname.clear();

			canname.sendKeys(candiname);

		} catch (Exception e) {

			Reporter.log("candidate name is not working" + e);
		}

	}

	public static void enterCandidateLastName(String candiLastname) {

		try {

			WebElement canlastname = DriverFunctions.getElementByXpath("//input[@placeholder='Lastname']");

			canlastname.clear();

			canlastname.sendKeys(candiLastname);

		} catch (Exception e) {

			Reporter.log("candidate last name is not working" + e);
		}
	}

	public static void enterCandidateEmail(String candiMailId) {

		try {

			WebElement canemail = DriverFunctions.getElementByXpath("//input[@placeholder='Email']");

			canemail.clear();

			canemail.sendKeys(candiMailId);

		} catch (Exception e) {

			Reporter.log("candidate emailid is not working" + e);
		}
	}

	public static void enterCandidateMobileNumber(String candiPhoneno) {

		try {

			WebElement canlastname = DriverFunctions.getElementByXpath("//input[@placeholder='Mobile Number']");

			canlastname.clear();

			canlastname.sendKeys(candiPhoneno);

		} catch (Exception e) {

			Reporter.log("candidate mobile number is not working" + e);
		}
	}

	public static void clickSaveButton() {

		DriverFunctions.getElementByXpath("//input[@value='Save']").click();

	}

	public static void verifyEditCandidateSuccessfulMessage() throws InterruptedException {

		Thread.sleep(2000);

		WebElement editsuccess = DriverFunctions
				.getElementByXpath("//div[text()='Candidate Details updated successfully']");

		String message = editsuccess.getText();

		System.out.println(message);

		if (message.equals("Candidate Details updated successfully")) {

			Reporter.log("Edit candidate details successfully updated");
		} else {

			Reporter.log("edit candidate details is not working");
		}

	}

	public static void verifyNegativeMessageForEditCandidate() {

		List<WebElement> errormsg = DriverFunctions.getElementsByTagName("p");

		for (int i = 0; i < errormsg.size(); i++) {

			String negativemsg = errormsg.get(i).getText();

			if (negativemsg.equals("* Enter the Name")) {

				Reporter.log("error message" + "----" + negativemsg);

			}

			if (negativemsg.equals("* Enter the Email")) {

				Reporter.log("error message" + "----" + negativemsg);

			}

			if (negativemsg.equals("* Enter the Mobile Number")) {

				Reporter.log("error message" + "----" + negativemsg);

			}

			if (negativemsg.equals("* Enter the valid Email")) {

				Reporter.log("error message" + "----" + negativemsg);

			}

			if (negativemsg.equals("* Enter the valid Mobile Number")) {

				Reporter.log("error message" + "----" + negativemsg);

			}

		}

	}

	public static void clickSelectInterviewerButton() throws InterruptedException {

		Thread.sleep(3000);

		try {
			DriverFunctions.getElementByXpath("//span[text()='Select Interviewers']").click();
		} catch (Exception e) {

			Reporter.log("selected interviewer button is not working" + e);
		}
	}

	public static void enterInterviewerNameSearchBox(String interviewername) {

		try {

			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//input[@placeholder='Search..']").sendKeys(interviewername);

		} catch (Exception e) {

			Reporter.log("enter interviwer name search box is not working" + e);
		}
	}

	public static void enterANotherInterviewerNameSearchBox(String interviewername_1) {

		try {

			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//input[@placeholder='Search..']").sendKeys(interviewername_1);

		} catch (Exception e) {

			Reporter.log("enter interviwer name search box is not working" + e);
		}
	}

	public static void clickEnterInterviewerNameSearchIcon() {

		try {

			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//i[@class='fa fa-search']").click();
		} catch (Exception e) {

			Reporter.log("enter interviewer name search icon is not working" + e);
		}
	}

	public static void clickInterviewerSelectButton() {

		try {
			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("(//button[text()='Select'])[1]").click();
		} catch (Exception e) {

			Reporter.log("click interviewer select button is not working" + e);
		}
	}

	public static void clickinterviewerUnselectButton() {

		try {

			List<WebElement> unselectbtn = DriverFunctions
					.getElementsByXpath("//button[@class='fa fa-check-circle fa-2x isSelected pull-right']");

			for (int i = 0; i < unselectbtn.size(); i++) {

				unselectbtn.get(i).click();
			}

		} catch (Exception e) {

			Reporter.log("un select button is not working");
			// TODO: handle exception
		}

	}

	public static void clickInterviewerDoneButton() {

		try {
			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//button[text()='Done']").click();
		} catch (Exception e) {

			Reporter.log("click interviewer done button is not working" + e);
		}
	}

	public static void clickSetAvailabilityButton() {

		try {
			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("(//a[text()=' Set Availability '])[1]").click();
		} catch (Exception e) {

			Reporter.log("click setavailability button is not working" + e);
		}
	}

	public static void clickSelectDateButton() {

		try {

			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//input[@placeholder='Select Date *']").click();
		} catch (Exception e) {

			Reporter.log("click setavailability button is not working" + e);
		}
	}

	public static void verifyScheduleRequestPendingstatus() {

		try {

			Thread.sleep(2000);

			WebElement statustext = DriverFunctions.getElementByXpath("//a[text()='Schedule Request Pending']");

			String status = statustext.getText();

			System.out.println(status);

			Assert.assertEquals(status, "Schedule Request Pending");

			Reporter.log("status should be" + "--" + status);

		} catch (Exception e) {
			Reporter.log("sechedule pending status is not working" + e);

			// TODO: handle exception
		}
	}

	public static void verifyReScheduleRequestPendingstatus() {

		try {

			Thread.sleep(2000);

			WebElement statustext = DriverFunctions.getElementByXpath("//a[text()='Re-Schedule Request Pending']");

			String status = statustext.getText();

			System.out.println(status);

			Assert.assertEquals(status, "Re-Schedule Request Pending");

			Reporter.log("status should be" + "--" + status);

		} catch (Exception e) {
			Reporter.log("resechedule pending status is not working" + e);

			// TODO: handle exception
		}
	}

	public static void clickScheduleRequestPendingStatus() {

		try {

			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//a[text()='Schedule Request Pending']").click();

		} catch (Exception e) {

			Reporter.log("schedule request status is not clickable");
			// TODO: handle exception
		}

	}

	public static void clickReScheduleRequestPendingStatus() {

		try {

			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//a[text()='Re-Schedule Request Pending']").click();

		} catch (Exception e) {

			Reporter.log("reschedule request status is not clickable");
			// TODO: handle exception
		}

	}

	public static void checkSelectedInterviewerList() throws InterruptedException {

		try {

			Thread.sleep(2000);

			WebElement table = DriverFunctions.getElementByXpath("(//table[@id='example1'])[1]");

			String tablelists = table.getText();

			System.out.println(tablelists);

			Reporter.log("first interviewer lists" + "----" + tablelists);

			Thread.sleep(30000);

			WebElement okbtn = DriverFunctions.getElementByXpath("(//button[text()='Ok'])[2]");

			okbtn.click();

		} catch (Exception e) {

			Reporter.log("interver list is not showing" + e);
			// TODO: handle exception
		}

	}

	public static void clickScheduleTab() {

		try {
			Thread.sleep(2000);

			WebElement scheduleTab = DriverFunctions.getElementByXpath("//div[text()=' Scheduled ']");

			scheduleTab.click();

		} catch (Exception e) {

			Reporter.log("schedule tab is not working");
			// TODO: handle exception
		}
	}

	public static void verifyScheduleStatus() throws InterruptedException {

		try {

			Thread.sleep(2000);

			WebElement statustext1 = DriverFunctions.getElementByXpath("//a[text()='Scheduled']");

			String status1 = statustext1.getText();

			System.out.println(status1);

			Assert.assertEquals(status1, "Scheduled");

			Reporter.log("the status should be " + status1);

			Thread.sleep(80000);

			DriverFunctions.driver.navigate().refresh();

			Thread.sleep(3000);

		} catch (Exception e) {

			Reporter.log("schedule status is not showing" + e);
		}
	}

	public static void verifyReScheduleStatus() throws InterruptedException {

		try {

			Thread.sleep(2000);

			WebElement statustext1 = DriverFunctions.getElementByXpath("//a[text()='Rescheduled']");

			String status1 = statustext1.getText();

			System.out.println(status1);

			Assert.assertEquals(status1, "Rescheduled");

			Reporter.log("the status should be " + status1);

			Thread.sleep(80000);

			DriverFunctions.driver.navigate().refresh();

			Thread.sleep(3000);

		} catch (Exception e) {

			Reporter.log("Reschedule status is not showing" + e);
		}
	}

	public static void clickProfileTab() {
		try {

			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//div[text()=' Profiles ']").click();

		} catch (Exception e) {

			Reporter.log("profile tab is not working" + e);
		}
	}

	public static void verifyFeedbackPendingStatus() {

		try {

			Thread.sleep(2000);

			WebElement statustext2 = DriverFunctions.getElementByXpath("//a[text()='Feedback Pending']");

			String status2 = statustext2.getText();

			System.out.println(status2);

			Assert.assertEquals(status2, "Feedback Pending");

			Reporter.log("the status should be " + status2);

		} catch (Exception e) {

			Reporter.log("feedback status is not showing" + "----" + e);
			// TODO: handle exception
		}
	}

	public static void clickFeedbackPendingstatus() {

		try {

			Thread.sleep(2000);

			WebElement feedbackbtn = DriverFunctions.getElementByXpath("//a[text()='Feedback Pending']");

			feedbackbtn.click();

		} catch (Exception e) {

			Reporter.log("feedback pending status is not clikable");
			// TODO: handle exception
		}
	}

	public static void viewFeedbackResults() {

		try {
			Thread.sleep(2000);

			WebElement statustext3 = DriverFunctions.getElementByXpath("(//div[@class='modal-body'])[8]");

			String status3 = statustext3.getText();

			System.out.println(status3);

			Reporter.log("Results" + "--------" + status3);

		} catch (Exception e) {

			Reporter.log("view feed back is not showing " + e);
			// TODO: handle exception
		}
	}

	public static void clickViewFeedbackCancelButton() throws InterruptedException {

		try {

			Thread.sleep(2000);

			WebElement cancelbtn1 = DriverFunctions.getElementByXpath("(//span[text()='×'])[5]");

			cancelbtn1.click();

			Thread.sleep(50000);

			DriverFunctions.driver.navigate().refresh();

			Thread.sleep(3000);

		} catch (Exception e) {

			Reporter.log("cancel button is not working" + e);

			// TODO: handle exception
		}
	}

	public static void verifySitScoreStatus() {

		try {

			Thread.sleep(2000);

			WebElement statustext4 = DriverFunctions.getElementByXpath("//div[@class='status col-mod-2']");

			String status4 = statustext4.getText();

			System.out.println(status4);

			Reporter.log(" the status should be " + status4);

			if (status4.equals("SIT 10") || status4.equals("SIT 9") || status4.equals("SIT 8")
					|| status4.equals("SIT 7") || status4.equals("SIT 6")) {

				WebElement selectbtn = DriverFunctions.getElementByXpath("//span[text()=' Select ']");

				selectbtn.click();

				WebElement yesbtn = DriverFunctions.getElementByXpath("//button[text()='Yes']");

				yesbtn.click();

			} else if (status4.equals("SIT 1") || status4.equals("SIT 2") || status4.equals("SIT 3")
					|| status4.equals("SIT 4") || status4.equals("SIT 5")) {

				WebElement rejbtn = DriverFunctions.getElementByXpath("//span[text()=' Reject ']");

				rejbtn.click();

				WebElement yesbtn = DriverFunctions.getElementByXpath("//button[text()='Yes']");

				yesbtn.click();

			} else {

				WebElement statustext5 = DriverFunctions.getElementByXpath("//div[@class='status col-mod-2']");

				String status5 = statustext5.getText();

				System.out.println(status5);

				Reporter.log(" the status should be " + status5);

			}

		} catch (Exception e) {

			Reporter.log("sit score is not showing" + e);
			// TODO: handle exception
		}
	}

	public static void verifySelectedOrRejectedStatus() {

		try {

			Thread.sleep(2000);

			WebElement status = DriverFunctions.getElementByXpath("//span[@class='direct-chat-timestamp']");

			String data = status.getText();

			Reporter.log("candidate is selected or not" + "----" + data);

			if (data.trim().equals(" Selected ")) {

				Thread.sleep(2000);

				DriverFunctions.getElementByXpath("//div[text()=' Selected ']").click();

			}

		} catch (Exception e) {

			Reporter.log("selected or rejected status is not showing" + e);

		}
	}

	public static void clickManualScheduleButton() {

		try {

			Thread.sleep(3000);

			DriverFunctions.getElementByXpath("//a[text()=' Schedule ']").click();

		} catch (Exception e) {

			Reporter.log("manual schedule is not working" + e);

			// TODO: handle exception
		}
	}

	public static void verifyDeclineStatus() throws InterruptedException {

		Thread.sleep(10000);

		DriverFunctions.driver.navigate().refresh();

		Thread.sleep(3000);

		WebElement statustext1 = DriverFunctions.getElementByXpath("//a[text()='Declined']");

		String status2 = statustext1.getText();

		Assert.assertEquals(status2, "Declined");

		System.out.println(status2);

		Reporter.log("the status should be " + "-----" + status2);
	}

	public static void clickDeclinewithSetavailability() {

		try {
			DriverFunctions.getElementByXpath("//a[@data-target='#setAvailability']").click();

		} catch (Exception e) {

			Reporter.log("decline with setavailability button is not working" + e);
			// TODO: handle exception
		}
	}

	public static void clickScheduleWithCancelButton() {

		try {

			Thread.sleep(3000);

			DriverFunctions.getElementByXpath("(//a[text()=' Cancel'])[1]").click();

		} catch (Exception e) {

			Reporter.log("cancel button is not working" + e);
			// TODO: handle exception
		}
	}

	public static void clickScheduleWithRescheduleButton() {

		try {

			Thread.sleep(3000);

			DriverFunctions.getElementByXpath("//a[text()=' Re-Schedule ']").click();

		} catch (Exception e) {

			Reporter.log("cancel button is not working" + e);
			// TODO: handle exception
		}
	}

	public static void cancelPopup_IsDisplayed() {

		boolean popupTitle = DriverFunctions.getElementByXpath("//h4[text()='Reason for Cancellation']").isDisplayed();

		if (popupTitle == true) {

			Reporter.log("popup Title is displayed");
		} else {

			Reporter.log("popup title is not displayed");
		}
	}

	public static void ReschedulePopup_IsDisplayed() {

		boolean popupTitle = DriverFunctions.getElementByXpath("//span[text()='Reschedule']").isDisplayed();

		if (popupTitle == true) {

			Reporter.log("popup Title is displayed");
		} else {

			Reporter.log("popup title is not displayed");
		}
	}

	public static void selectReason(String Reason) {

		try {

			Thread.sleep(2000);
			WebElement reason = DriverFunctions.getElementByXpath("//select[@id='reason']");

			Select s = new Select(reason);

			s.selectByVisibleText(Reason);

		} catch (Exception e) {

			Reporter.log("select Reason is not working" + e);
			// TODO: handle exception
		}
	}

	public static void enterComments(String comment) throws InterruptedException {

		Thread.sleep(3000);

		WebElement comments = DriverFunctions.getElementByXpath("//textarea[@placeholder='Enter Comments*']");

		comments.sendKeys(comment);

	}

	public static void clickPopupSubmitButton() throws InterruptedException {

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("//input[@id='submit']").click();

	}

	public static void clickPopupRescheduleSubmitButton() throws InterruptedException {

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("//button[text()='Submit']").click();

	}

	public static void verifyOpenStatus() throws InterruptedException {

		Thread.sleep(3000);

		WebElement openstatus = DriverFunctions.getElementByXpath("//a[text()='Open']");

		String datas = openstatus.getText();

		Assert.assertEquals(datas, "Open");

		Reporter.log("status should be" + "-----" + datas);

	}

	public static void verifyFilterByStatus(String text) throws InterruptedException {

		Thread.sleep(3000);

		WebElement status = DriverFunctions.getElementByXpath("//select[@placeholder='Select Status']");

		Select s = new Select(status);

		s.selectByVisibleText(text);

		Thread.sleep(2000);

		List<WebElement> statuscount = DriverFunctions.getElementsByXpath("//div[@class='status col-mod-2']");

		int count = statuscount.size();

		Reporter.log("search by status count" + "--------" + count);

		Thread.sleep(2000);

		List<WebElement> postcount = DriverFunctions.getElementsByXpath("//div[@class='postArea2 col-mod-12']");

		int postcounts = postcount.size();

		if (count == postcounts) {

			Reporter.log("status matched the count");
		}

		for (int i = 0; i < statuscount.size(); i++) {

			String data = statuscount.get(i).getText();

			if (data.equals(text)) {

				Reporter.log("search is working fine");

			}

		}

	}

	public static void verifyFilterBySitScore(String sit) {

		WebElement score = DriverFunctions.getElementByXpath("//select[@placeholder='Select Score']");

		Select s = new Select(score);

		s.selectByVisibleText(sit);

		List<WebElement> statuscount = DriverFunctions.getElementsByXpath("//div[@class='status col-mod-2']");

		int count = statuscount.size();

		Reporter.log("search by status count" + "--------" + count);

		List<WebElement> postcount = DriverFunctions.getElementsByXpath("//div[@class='postArea2 col-mod-12']");

		int postcounts = postcount.size();

		if (count == postcounts) {

			Reporter.log("status matched the count");
		}

		for (int i = 0; i < statuscount.size(); i++) {

			String data = statuscount.get(i).getText();

			if (data.equals(sit)) {

				Reporter.log("search is working fine");

			}

		}

	}

	public static void clickSearchClearButton() {

		DriverFunctions.getElementByXpath("//button[@type='button']//b[text()='Clear']").click();

	}

	public static void enterSearchByName(String name) throws InterruptedException {

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("//input[@placeholder='Search..']").sendKeys(name);

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("//i[@class='fa fa-search']").click();

	}

	public static void clickShortlistedButton() throws InterruptedException {

		Thread.sleep(3000);

		DriverFunctions.getElementByXpath("(//button[text()='Shortlist'])[1]").click();

	}

	public static void verifyShortlistedMessage() throws InterruptedException {

		Thread.sleep(1000);

		WebElement message = DriverFunctions.getElementByXpath("//div[text()='Candidate Shortlisted Successfully']");

		String data = message.getText();

		if (data.equals("Candidate Shortlisted Successfully")) {

			Reporter.log("successfully shortlisted the candidate" + "---" + data);
		} else {

			Reporter.log("shortlisted message is not displayed ");
		}

	}

	public static void verifyConfirmationPendingStatus() throws InterruptedException {

		WebElement status = DriverFunctions.getElementByXpath("(//div[@class='status col-mod-2'])[1]");

		String data = status.getText();

		Reporter.log("after shortlisted status should be" + "-------" + data);

		Thread.sleep(30000);

		DriverFunctions.driver.navigate().refresh();

		Thread.sleep(2000);

	}

	public static void clickShortlistedTab() throws InterruptedException {

		Thread.sleep(3000);

		DriverFunctions.getElementByXpath("//div[text()='Shortlisted']").click();

	}

	public static void clickScheduleButtonWithDropdown(String text) throws InterruptedException {

		DriverFunctions.getElementByXpath("(//a[text()=' Schedule '])[1]").click();

		Thread.sleep(2000);

		List<WebElement> lists = DriverFunctions
				.getElementsByXpath("//div[@class='dropdown-menu logmenu']/following::div[@class='menu']");

		for (int i = 0; i < lists.size(); i++) {

			String data = lists.get(i).getText();

			if (data.equals(text)) {

				lists.get(i).click();
			}

		}

	}

	public static void clickSelectInterviewerWithDropdown(String type) throws InterruptedException {

		DriverFunctions.getElementByXpath("//span[text()='Select Interviewers'] ").click();

		Thread.sleep(2000);

		List<WebElement> lists = DriverFunctions.getElementsByXpath("(//div[@class='dropdown-menu logmenu'])[1]//a");

		for (int i = 0; i < lists.size(); i++) {

			String data = lists.get(i).getText();

			if (data.equals(type)) {

				lists.get(i).click();
			}

		}

	}

	public static void verifyScheduleInitiatedStatus() {

		try {

			Thread.sleep(2000);

			WebElement statustext2 = DriverFunctions.getElementByXpath("//a[text()='Schedule Initiated ']");

			String status2 = statustext2.getText();

			System.out.println(status2);

			Assert.assertEquals(status2.trim(), "Schedule Initiated");

			Reporter.log("the status should be " + "-------" + status2);

		} catch (Exception e) {

			Reporter.log("schedule intiated status is not showing" + "----" + e);
			// TODO: handle exception
		}

	}

	public static void clickShortlistedTabWithRefresh() throws InterruptedException {

		Thread.sleep(40000);

		DriverFunctions.driver.navigate().refresh();

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("//div[text()='Shortlisted']").click();

	}

	public static void clickManualScheduleForJd() throws InterruptedException {

		Thread.sleep(3000);

		DriverFunctions.getElementByXpath("(//a[@style='color: blue;'])[1]").click();

	}

	public static void verifyScheduleReInitiatedStatus() {

		try {

			Thread.sleep(2000);

			WebElement statustext2 = DriverFunctions.getElementByXpath("//a[text()='Schedule ReInitiated ']");

			String status2 = statustext2.getText();

			System.out.println(status2);

			Assert.assertEquals(status2.trim(), "Schedule ReInitiated");

			Reporter.log("the status should be " + "-------" + status2);

		} catch (Exception e) {

			Reporter.log("schedule Reintiated status is not showing" + "----" + e);
			// TODO: handle exception
		}

	}

	public static void clickXButton() {

		DriverFunctions.getElementByXpath("//i[@class='fa fa-times']").click();

	}

	public static void verifyCancelledStatus() {

		try {

			Thread.sleep(2000);

			WebElement statustext2 = DriverFunctions.getElementByXpath("//span[text()=' Cancelled ']");

			String status2 = statustext2.getText();

			System.out.println(status2);

			Assert.assertEquals(status2.trim(), "Cancelled");

			Reporter.log("the status should be " + "-------" + status2);

		} catch (Exception e) {

			Reporter.log("cancelled status is not showing" + "----" + e);
			// TODO: handle exception
		}

	}

	public static void clickRescheduleWithDropdown(String text) throws InterruptedException {
		
		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("//a[text()=' Re-Schedule ']").click();

		Thread.sleep(2000);

		List<WebElement> lists = DriverFunctions.getElementsByXpath("(//div[@class='dropdown-menu logmenu'])[2]//a");

		for (int i = 0; i < lists.size(); i++) {

			String data = lists.get(i).getText();

			if (data.equals(text)) {

				lists.get(i).click();
			}

		}

	}

	public static void verifyRescheduleInitiatedStatus() {

		try {

			Thread.sleep(2000);

			WebElement statustext2 = DriverFunctions.getElementByXpath("//a[text()='Reschedule Initiated ']");

			String status2 = statustext2.getText();

			System.out.println(status2);

			Assert.assertEquals(status2.trim(), "Reschedule Initiated");

			Reporter.log("the status should be " + "-------" + status2);

		} catch (Exception e) {

			Reporter.log("reschedule initated status is not showing" + "----" + e);
			// TODO: handle exception
		}

	}

	public static void clickViewHistory() throws InterruptedException {

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("//a[text()=' View History ']").click();

		WebElement table = DriverFunctions.getElementByXpath("//table[@id='example1']");

		List<WebElement> row = table.findElements(By.tagName("tr"));

		for (int i = 0; i < row.size(); i++) {

			List<WebElement> col = row.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < col.size(); j++) {

				String data = col.get(j).getText();

				System.out.print(data + " ");

				Reporter.log("All the rounds schedule details and sit score" + data + "   ");

			}
			System.out.println();

		}

		String score = DriverFunctions.getElementByXpath("//table[@id='example1']//tr").getText();
	
		DriverFunctions.getElementByXpath("(//button[text()='Ok'])[3]").click();
		
		String orgscore = 	   DriverFunctions.getElementByXpath("(//div[@class='status col-mod-2']//a)[1]").getText();

		if(score.equals(orgscore)){
			
			Reporter.log("sit score matched recent score"+"----"+"Pass");
		}
		
		Thread.sleep(3000);

	}
	
	

}
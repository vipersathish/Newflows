package com.Screenit.version3.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.Screenit.version3.Initializer.DriverFunctions;

public class DashBoardPage {

	public static void clickUploadicon() throws InterruptedException {

		Thread.sleep(3000);

		try {

			DriverFunctions.getElementByXpath("//span[text()='Upload ']").click();

		} catch (Exception e) {

			Reporter.log("clickuploadicon is not working" + "---" + e);
		}
	}

	public static void clickIDButton() throws InterruptedException {

		Thread.sleep(3000);

		try {
			DriverFunctions.getElementByXpath("//a[text()='Interviewer Description']").click();
		} catch (Exception e) {

			Reporter.log("click id button is not working" + "----" + e);
		}
	}

	
	public static void clickJDButton() throws InterruptedException {

		Thread.sleep(3000);

		try {
			DriverFunctions.getElementByXpath("//a[text()='Job Description']").click();
		} catch (Exception e) {

			Reporter.log("click Jd button is not working" + "----" + e);
		}
	}

	
	public static void verifyIDPopUpTittle() throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement popuptitle = DriverFunctions.getElementByXpath("//h4[@class='modal-title']");

			String title = popuptitle.getText();

			Assert.assertEquals(title, "Interviewer Description ID");

			Reporter.log("Title of the popup name" + "--------" + title);
		} catch (Exception e) {

			Reporter.log("verify id popup title is not matched" + "------" + e);
		}
	}

	public static void verifyJDPopUpTittle() throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement popuptitle = DriverFunctions.getElementByXpath("//h4[@class='modal-title']");

			String title = popuptitle.getText();

			Assert.assertEquals(title, "Job Description JD");

			Reporter.log("Title of the popup name" + "--------" + title);
		} catch (Exception e) {

			Reporter.log("verify Jd popup title is not matched" + "------" + e);
		}
	}

	
	
	public static void clickUploadButton(String file) throws InterruptedException {

		Thread.sleep(3000);

		try {
			DriverFunctions.getElementByXpath("//input[@id='file1']").sendKeys(file);

		} catch (Exception e) {

			Reporter.log("click upload button is not working" + "------" + e);
		}
	}

	public static void clickSubmitButton() throws InterruptedException {

		Thread.sleep(3000);

		try {

			DriverFunctions.getElementByXpath("//button[text()='Submit']").click();

		} catch (Exception e) {

			Reporter.log("click submit button is not working" + "-----" + e);
		}
	}

	public static void clickCancelButon() throws InterruptedException {

		Thread.sleep(3000);

		try {
			DriverFunctions.getElementByXpath("//button[text()='Cancel']").click();
		} catch (Exception e) {

			Reporter.log("click cancel button is not working" + "----" + e);
		}
	}

	public static void verifyPostPopuptitle() throws InterruptedException {

		Thread.sleep(3000);

		try {
			WebElement popuptitle = DriverFunctions
					.getElementByXpath("//h4[text()='Create Interviewer Description ID']");

			String title = popuptitle.getText();

			Assert.assertEquals(title, "Create Interviewer Description ID");

			Reporter.log("Title of the post popup name" + "------" + title);

		} catch (Exception e) {

			Reporter.log("Verify post popup title is not matched" + "----" + e);
		}
	}
	
	public static void verifyPostPopuptitleForJD() throws InterruptedException {

		Thread.sleep(3000);

		try {
			WebElement popuptitle = DriverFunctions
					.getElementByXpath("//h4[text()='Create Job Description JD']");

			String title = popuptitle.getText();

			Assert.assertEquals(title, "Create Job Description JD");

			Reporter.log("Title of the post popup name for JD" + "------" + title);

		} catch (Exception e) {

			Reporter.log("Verify post popup title is not matched" + "----" + e);
		}
	}

	public static void verifyTitleOfThePost() throws InterruptedException {

		Thread.sleep(3000);

		try {
			boolean title = DriverFunctions.getElementByXpath("//input[@placeholder='Job Title*']").isDisplayed();

			if (title == true) {

				Reporter.log("Autopopulate name is working fine");
			} else {

				Reporter.log("Autopopulated name is not working fine" + "--------" + title);
			}
		} catch (Exception e) {

			Reporter.log("verifytitle of the post is not working" + "-------" + e);
		}

	}
	
	public static void verifyTitleOfThePostForJd() throws InterruptedException {

		Thread.sleep(3000);

		try {
			boolean title = DriverFunctions.getElementByXpath("//input[@placeholder='Job Title*']").isDisplayed();

			if (title == true) {

				Reporter.log("Autopopulate name is working fine");
			} else {

				Reporter.log("Autopopulated name is not working fine" + "--------" + title);
			}
		} catch (Exception e) {

			Reporter.log("verifytitle of the post is not working" + "-------" + e);
		}

	}

	public static void EnterTheTitle(String title) throws InterruptedException {

		try {
			Thread.sleep(2000);

			DriverFunctions.getElementByXpath("//input[@placeholder='Job Title*']").sendKeys(title);
		} catch (Exception e) {

			Reporter.log("title box is not working" + e);
		}
	}

	public static void selectAttachment(String file_2) {

		try {

			DriverFunctions.getElementByXpath("//div[text()='Select the File ']").sendKeys(file_2);

		} catch (Exception e) {

			Reporter.log("selectattachement is not working" + e);
		}
	}

	public static void verifyDateValidity() throws InterruptedException {

		Thread.sleep(3000);

		try {

			Boolean datevalidity = DriverFunctions.getElementByXpath("//input[@placeholder='Select Validity *']")
					.isDisplayed();

			if (datevalidity == true) {

				Reporter.log("Autopopulate date validity is working fine");

			} else {

				Reporter.log("Autopopulated date validity not working fine" + "--------" + datevalidity);
			}
		} catch (Exception e) {

			Reporter.log("Verify the date validity is not working" + "------" + e);

		}

	}

	public static void clickDateValidity() throws InterruptedException {

		try {

			Thread.sleep(2000);

			WebElement datevaliditybtn = DriverFunctions.getElementByXpath("//input[@placeholder='Select Validity *']");

			datevaliditybtn.click();

		} catch (Exception e) {

			Reporter.log("date validity button is not working" + e);

		}
	}

	public static void selectDate(String date) throws InterruptedException {

		
		Thread.sleep(2000);
		
		try {
			

			List<WebElement> Alldate = DriverFunctions
					.getElementsByXpath("//div[@class='vdatetime-calendar__month__day']");

			for (int i = 0; i < Alldate.size(); i++) {

				String data = Alldate.get(i).getText();

				if (data.equals(date)) {

					Alldate.get(i).click();
				
				}
			}

		} catch (Exception e) {

			Reporter.log("Select date is not working" + e);
		}

	}
	
public static void selectAnotherDate(String date_1) throws InterruptedException {

		
		Thread.sleep(2000);
		
		try {
			

			List<WebElement> Alldate = DriverFunctions
					.getElementsByXpath("//div[@class='vdatetime-calendar__month__day']");

			for (int i = 0; i < Alldate.size(); i++) {

				String data = Alldate.get(i).getText();

				if (data.equals(date_1)) {

					Alldate.get(i).click();
				
				}
			}

		} catch (Exception e) {

			Reporter.log("Select date is not working" + e);
		}

	}

	public static void selectTime(String time) throws InterruptedException {

	
		
		try {
			Thread.sleep(3000);
			
			List<WebElement> Alldate = DriverFunctions
					.getElementsByXpath("//div[@class='vdatetime-time-picker__list vdatetime-time-picker__list--hours']//div");

			for (int i = 0; i < Alldate.size(); i++) {

				String data = Alldate.get(i).getText();

				if (data.equals(time)) {

					Alldate.get(i).click();
					
					
				}
			}

		} catch (Exception e) {

			Reporter.log("Select time is not working" + e);
		}

	}
	
	public static void selectAnotherTime(String time_1) {

		try {

			Thread.sleep(2000);
			
			List<WebElement> Alldate = DriverFunctions
					.getElementsByXpath("//div[@class='vdatetime-time-picker__list vdatetime-time-picker__list--hours']//div");

			for (int i = 0; i < Alldate.size(); i++) {

				String data = Alldate.get(i).getText();

				if (data.equals(time_1)) {

					Alldate.get(i).click();
					
					
				}
			}

		} catch (Exception e) {

			Reporter.log("Select time is not working" + e);
		}

	}

	public static void selectSeconds(String sec) {

		try {
			
			Thread.sleep(2000);

			List<WebElement> Alldate = DriverFunctions
					.getElementsByXpath("//div[@class='vdatetime-time-picker__list vdatetime-time-picker__list--minutes']//div");

			for (int i = 0; i < Alldate.size(); i++) {

				String data = Alldate.get(i).getText();

				if (data.equals(sec)) {

					Alldate.get(i).click();
					
				}
			}

		} catch (Exception e) {

			Reporter.log("Select second is not working" + e);
		}

	}
	
	public static void selectAnotherSeconds(String sec_1) {

		try {
			
			Thread.sleep(2000);

			List<WebElement> Alldate = DriverFunctions
					.getElementsByXpath("//div[@class='vdatetime-time-picker__list vdatetime-time-picker__list--minutes']//div");

			for (int i = 0; i < Alldate.size(); i++) {

				String data = Alldate.get(i).getText();

				if (data.equals(sec_1)) {

					Alldate.get(i).click();
					
				}
			}

		} catch (Exception e) {

			Reporter.log("Select second is not working" + e);
		}

	}

	public static void selectPreffixOrSuffix(String preorsuf) {

		try {

			Thread.sleep(2000);
			
			List<WebElement> Alldate = DriverFunctions
					.getElementsByXpath("//div[@class='vdatetime-time-picker__list vdatetime-time-picker__list--suffix']//div");

			for (int i = 0; i < Alldate.size(); i++) {

				String data = Alldate.get(i).getText();

				if (data.equals(preorsuf)) {

					Alldate.get(i).click();
					
				
				}
			}

		} catch (Exception e) {

			Reporter.log("Select second is not working" + e);
		}

	}
	
	public static void selectAnotherPreffixOrSuffix(String preorsuf_1) {

		try {

			Thread.sleep(2000);
			
			List<WebElement> Alldate = DriverFunctions
					.getElementsByXpath("//div[@class='vdatetime-time-picker__list vdatetime-time-picker__list--suffix']//div");

			for (int i = 0; i < Alldate.size(); i++) {

				String data = Alldate.get(i).getText();

				if (data.equals(preorsuf_1)) {

					Alldate.get(i).click();
					
				
				}
			}

		} catch (Exception e) {

			Reporter.log("Select second is not working" + e);
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

	public static void SelectOverAllExperience(String Overallexp) throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement overallexp = DriverFunctions.getElementByXpath("(//select[@class='form-control'])[1]");

			Select s = new Select(overallexp);

			s.selectByVisibleText(Overallexp);

			Thread.sleep(3000);

			String text = overallexp.getText();

			if (text.isEmpty()) {

				System.out.println("selected overall experience is not highlighted");

				Reporter.log("selected overall experience is not highlighted" + "--" + text);
			} else {

				System.out.println("sucessfully highlighted the overall experience" + "------" + text);

				Reporter.log("sucessfully highlighted the overall experience" + "-----" + text);
			}
		} catch (Exception e) {

			Reporter.log("select overall experience is not working" + "-----" + e);
		}

	}
	
	public static void SelectMinumumYears(String minyear) throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement overallexp = DriverFunctions.getElementByXpath("(//select[@class='form-control'])[1]");

			Select s = new Select(overallexp);

			s.selectByVisibleText(minyear);

			Thread.sleep(3000);

			String text = overallexp.getText();

			if (text.isEmpty()) {

				System.out.println("selected overall experience is not highlighted");

				Reporter.log("selected overall experience is not highlighted" + "--" + text);
			} else {

				System.out.println("sucessfully highlighted the overall experience" + "------" + text);

				Reporter.log("sucessfully highlighted the overall experience" + "-----" + text);
			}
		} catch (Exception e) {

			Reporter.log("select overall experience is not working" + "-----" + e);
		}

	}


	public static void SelectMonth(String months) throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement month = DriverFunctions.getElementByXpath("(//select[@class='form-control'])[2]");

			Select s = new Select(month);

			s.selectByVisibleText(months);

			Thread.sleep(4000);

			String text = month.getText();

			if (text.isEmpty()) {

				System.out.println("selected month is not highlighted");

				Reporter.log("selected month is not highlighted" + "-----" + text);
			} else {

				System.out.println("sucessfully highlighted the months" + "------" + text);

				Reporter.log("sucessfully highlighted the months" + "-----" + text);
			}

		} catch (Exception e) {

			Reporter.log("select month is not working" + "------" + e);
		}

	}
	
	public static void SelectMaximumYears(String maxyear) throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement month = DriverFunctions.getElementByXpath("(//select[@class='form-control'])[2]");

			Select s = new Select(month);

			s.selectByVisibleText(maxyear);

			Thread.sleep(4000);

			String text = month.getText();

			if (text.isEmpty()) {

				System.out.println("selected month is not highlighted");

				Reporter.log("selected month is not highlighted" + "-----" + text);
			} else {

				System.out.println("sucessfully highlighted the months" + "------" + text);

				Reporter.log("sucessfully highlighted the months" + "-----" + text);
			}

		} catch (Exception e) {

			Reporter.log("select month is not working" + "------" + e);
		}

	}

	public static void ChoosePrimarySkills(String primaryskill) throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement primaryskillbtn = DriverFunctions.getElementByXpath("(//div[@class='multiselect__tags'])[1]");

			primaryskillbtn.click();

			List<WebElement> primaryskillList = DriverFunctions
					.getElementsByXpath("(//ul[@class='multiselect__content'])[1]//span");

			for (int i = 0; i < primaryskillList.size(); i++) {

				String text = primaryskillList.get(i).getText();

				String[] name = primaryskill.split(",");

				for (int j = 0; j < name.length; j++) {

					if (name[j].toLowerCase().equals(text.toLowerCase())) {

						primaryskillList.get(i).click();

						String skill = primaryskillbtn.getText();

						System.out.println(skill);

						Reporter.log("Selected primary skill are " + "-----" + skill);

						if (j != (name.length - 1)) {

							WebElement primaryskillbtn1 = DriverFunctions
									.getElementByXpath("(//div[@class='multiselect__tags'])[1]");

							primaryskillbtn1.click();

							System.out.println("click");
						}
						if (j == (name.length - 1)) {

							break;

						}

					}

				}

			}

		} catch (Exception e) {

			// Reporter.log("choose primary skill is not working" + "----" + e);
		}

	}

	public static void ChooseSecondarySkills(String secondaryskill) throws InterruptedException {

		try {

			Thread.sleep(2000);

			WebElement secondaryskillbtn = DriverFunctions.getElementByXpath("(//div[@class='multiselect__tags'])[2]");

			secondaryskillbtn.click();

			List<WebElement> secondaryskillList = DriverFunctions
					.getElementsByXpath("(//ul[@class='multiselect__content'])[2]//span");

			for (int i = 0; i < secondaryskillList.size(); i++) {

				String text = secondaryskillList.get(i).getText();

				String[] name = secondaryskill.split(",");

				for (int j = 0; j < name.length; j++) {

					if (name[j].toLowerCase().equals(text.toLowerCase())) {

						secondaryskillList.get(i).click();

						String skills = secondaryskillbtn.getText();

						Reporter.log("selected secondary skills are :" + skills);

						if (j != (name.length - 1)) {

							WebElement secondaryskillbtn1 = DriverFunctions
									.getElementByXpath("(//div[@class='multiselect__tags'])[2]");

							secondaryskillbtn1.click();
						}

						if (j == (name.length - 1)) {

							break;

						}

					}

				}

			}
		} catch (Exception e) {

			// Reporter.log("choose secondary skill is not working" + "----" +
			// e);

		}

	}

	public static void verifyResumeAttachment() throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement resumeatc = DriverFunctions.getElementByXpath("//div[@class='show-doc']");

			String resume = resumeatc.getText();

			Thread.sleep(3000);

			if (resume.isEmpty()) {

				Reporter.log("Auto populated resume attachment is not working");
			} else {

				Reporter.log("Auto populated resume attachment is working fine" + "-----" + resume);
			}
		} catch (Exception e) {

			Reporter.log("Verify resume attachmet is not working" + "---" + e);
		}
	}

	public static void EnterJobDescription(String jobdescription) throws InterruptedException {

		Thread.sleep(3000);

		try {

			WebElement jd = DriverFunctions.getElementByXpath("//textarea[@placeholder='Enter Job Description']");

			jd.sendKeys(jobdescription);
		} catch (Exception e) {

			Reporter.log("enter the jd is not working" + "----" + e);
		}
	}

	public static void EnterRemark(String remark) throws InterruptedException {

		Thread.sleep(3000);

		try {
			DriverFunctions.getElementByXpath("//textarea[@placeholder='Enter Remarks']").sendKeys(remark);

		} catch (Exception e) {

			Reporter.log("enter remark is not working" + "-----" + e);
		}
	}

	public static void clickPostButton() throws InterruptedException {

		Thread.sleep(3000);

		try {

			DriverFunctions.getElementByXpath("//input[@id='submit']").click();

		} catch (Exception e) {

			Reporter.log("Post button is not working" + "-----" + e);
		}
	}

	public static void clickResetButton() throws InterruptedException {

		Thread.sleep(3000);

		try {

			DriverFunctions.getElementByXpath("//input[@id='resetbtn']").click();

		} catch (Exception e) {

			Reporter.log("Reset button is not working" + e);
		}

	}

	public static void verifyCancelButton() throws InterruptedException {

		Thread.sleep(3000);

		try {
			boolean cancelbtn = DriverFunctions.getElementByXpath("(//button[@type='button'])[2]").isDisplayed();

			if (cancelbtn == true) {

				DriverFunctions.getElementByXpath("(//button[@type='button'])[2]").click();

			} else {

				Reporter.log("Cance button is not showing");

			}

		} catch (Exception e) {

			Reporter.log("Cancel is click or not" + e);
		}

	}

	public static void verifyPostCreatedOrNOT() {

		WebElement data2 = DriverFunctions.getElementByXpath("//div[text()='ID created successfully']");

		String message = data2.getText();

		System.out.println(message);

		Assert.assertEquals(message, "ID created successfully");

		if (message.equals("ID created successfully")) {

			Reporter.log("Post should be created successfully");

		} else {

			Reporter.log("Post is not created");

		}
	}
	
	public static void verifyPostCreatedOrNOTForJD() {

		WebElement data2 = DriverFunctions.getElementByXpath("//div[text()='JD created successfully']");

		String message = data2.getText();

		System.out.println(message);

		Assert.assertEquals(message, "JD created successfully");

		if (message.equals("JD created successfully")) {

			Reporter.log("Post should be created successfully");

		} else {

			Reporter.log("Post is not created");

		}
	}

	public static void verifyPostCreatedOrNOTWithResetButton() {

		List<WebElement> errormsg = DriverFunctions.getElementsByXpath("//p[@class='login-alert-msg error-content']");

		for (int i = 0; i < errormsg.size(); i++) {

			String errormessage = errormsg.get(i).getText();

			if (errormessage.equals("* Enter the job title")) {

				Reporter.log("please check the job tittle is not working" + "----" + errormessage);

			}
			if (errormessage.equals("* Select the primary skills")) {

				Reporter.log("please check the primary skill is not working" + "-----" + errormessage);

			}
			if (errormessage.equals("* Enter the job description")) {

				Reporter.log("please check the job description is not working" + "----" + errormessage);

			}
			if (errormessage.equals("* Select post validity")) {

				Reporter.log("please check the post validity is not working " + "---" + errormessage);

			}
			if (errormessage.equals("* Select the year")) {

				Reporter.log("please check the select the year is  not working" + "----" + errormessage);

			}
			if (errormessage.equals("* Select the month")) {

				Reporter.log("please check the select the month is  not working" + "----" + errormessage);
			}
		}

	}
	
	public static void verifyPostCreatedOrNOTWithResetButtonForJd() {

		List<WebElement> errormsg = DriverFunctions.getElementsByXpath("//p[@class='login-alert-msg error-content']");

		for (int i = 0; i < errormsg.size(); i++) {

			String errormessage = errormsg.get(i).getText();

			if (errormessage.equals("* Enter the job title")) {

				Reporter.log("please check the job tittle is not working" + "----" + errormessage);

			}
			
			if (errormessage.equals("* Enter Minimum Salary")) {

				Reporter.log("please check the minimum salary is not working" + "----" + errormessage);

			}
			
			if (errormessage.equals("* Enter Maximum Salary")) {

				Reporter.log("please check the maximum salary is not working" + "----" + errormessage);

			}
			
			
			if (errormessage.equals("* Select the primary skills")) {

				Reporter.log("please check the primary skill is not working" + "-----" + errormessage);

			}
			if (errormessage.equals("* Enter the job description")) {

				Reporter.log("please check the job description is not working" + "----" + errormessage);

			}
			if (errormessage.equals("* Select post validity")) {

				Reporter.log("please check the post validity is not working " + "---" + errormessage);

			}
			if (errormessage.equals("* Select the year")) {

				Reporter.log("please check the select the year is  not working" + "----" + errormessage);

			}
			if (errormessage.equals("* Enter Job location")) {

				Reporter.log("please check the job location is  not working" + "----" + errormessage);
			}
			
			if (errormessage.equals("* Enter vacancy")) {

				Reporter.log("please check the enter vacancy is  not working" + "----" + errormessage);
			}
		}

	}

	public static void selectIdOrJd(String flow) throws InterruptedException {

		
		
		try {

			Thread.sleep(2000);
			
			WebElement dropdown = DriverFunctions.getElementByXpath("//select[@placeholder='Select Type']");

			Select drop = new Select(dropdown);

			drop.selectByValue(flow);


		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("dropdown not working"+"---"+e) ;
		}
	}

	public static void clickProfileButton() throws InterruptedException {

		Thread.sleep(2000);
		
		try {

			DriverFunctions.getElementByXpath("(//div[text()='Profiles'])[1]").click();

		} catch (Exception e) {

			Reporter.log("click profile button is not working" + e);
		}
	}

	public static void clickHomeButton() {

		try {

			WebElement homebtn = DriverFunctions.getElementByXpath("//a[text()='Home ']");

			homebtn.click();

		} catch (Exception e) {

			Reporter.log("click Home button is not working" + e);
		}

	}

	public static void isDisplayed_HomeIcon() {

		try {

			boolean homeicon = DriverFunctions.getElementByXpath("//a[@class='navbar-brand']").isDisplayed();

			Reporter.log("Home icon is displayed or not" + "-------" + homeicon);

		} catch (Exception e) {

			Reporter.log("Home icon is not displayed" + "-------" + e);
			// TODO: handle exception
		}

	}

	public static void isDisplayed_HomeButton() {

		try {

			boolean homeicon = DriverFunctions.getElementByXpath("//a[@class='navbar-brand']").isDisplayed();

			Reporter.log("Home button is displayed or not" + "-------" + homeicon);

		} catch (Exception e) {

			// TODO: handle exception

			Reporter.log("Home button is not displayed " + "-------" + e);

		}

	}

	public static void clickReportButton() throws InterruptedException {

		try {

			WebElement Reportbtn = DriverFunctions.getElementByXpath("//a[text()='Report ']");

			if (Reportbtn.isDisplayed()) {

				WebElement reportArrowbtn = DriverFunctions.getElementByXpath("//span[@class='caret']");

				reportArrowbtn.click();

				Thread.sleep(2000);

				List<WebElement> reportlist = DriverFunctions.getElementsByXpath("//ul[@role='menu']//li");

				for (int i = 0; i < reportlist.size(); i++) {

					String reportText = reportlist.get(i).getText();

					Reporter.log("please check when clicking the Report button it shows " + "------" + reportText);

				}

			} else {

				Reporter.log("report button has not showing");

			}

		} catch (Exception e) {

			Reporter.log("report button is not working" + e);
		}
	}

	public static void isDisplayed_UploadButton() {

		try {
			boolean uploadbtn = DriverFunctions.getElementByXpath("//span[text()='Upload ']").isDisplayed();

			Reporter.log("upload button is displayed or not" + "--------" + uploadbtn);

		} catch (Exception e) {

			Reporter.log("uplaodbutton is not displayed" + e);

		}

	}

	public static void isDisplayed_UploadIcon() {

		try {

			boolean uploadicon = DriverFunctions.getElementByXpath("//i[@class='fa fa-cloud-upload']").isDisplayed();

			Reporter.log("upload button is displayed or not" + "--------" + uploadicon);

		} catch (Exception e) {

			Reporter.log("uplaodicon is not displayed" + e);

		}

	}

	public static void isDisplayed_BellNotificationIcon() {

		try {

			boolean bellnotification = DriverFunctions.getElementByXpath("//img[@data-toggle = 'modal']").isDisplayed();

			Reporter.log("bell notification is displayed or not" + "--------" + bellnotification);

		} catch (Exception e) {

			Reporter.log("bell notification is not displayed" + e);

		}

	}

	public static void isDisplayed_ProfileIcon() {

		try {

			boolean profileicon = DriverFunctions.getElementByXpath("//img[@class='user-image']").isDisplayed();

			Reporter.log("profileicon is displayed or not" + "--------" + profileicon);

		} catch (Exception e) {

			Reporter.log("profileicon is not displayed" + e);

		}

	}

	public static void isDisplayed_ProfileIconArrow() throws InterruptedException {

		try {

			WebElement profilearrowbtn = DriverFunctions.getElementByXpath("//i[@class='fa fa-caret-down ml-5']");

			profilearrowbtn.click();

			Thread.sleep(2000);

			List<WebElement> profilelist = DriverFunctions.getElementsByXpath("(//ul[@class='menu'])[2]//li");

			for (int i = 0; i < profilelist.size(); i++) {

				String prflist = profilelist.get(i).getText();

				Reporter.log("profile lists are :" + "----------" + prflist);
			}

		} catch (Exception e) {

			Reporter.log("profile arrow button is not working" + e);
		}
	}

	public static void isDisplayed_PostName() {

		try {
			WebElement postname = DriverFunctions.getElementByXpath("//h3[text()=' Recent JDs and IDs ']");

			boolean postnameis = postname.isDisplayed();

			Reporter.log("post title is displayed or not" + "-------" + postnameis);

			String name = postname.getText();

			Reporter.log("check the PostTitle is " + "---------" + name);
		} catch (Exception e) {

			Reporter.log("postname is not displayed" + e);
		}
	}

	public static void isDisplayed_ProfilePostLists() {

		try {

			Thread.sleep(3000);

			List<WebElement> profilepostlists = DriverFunctions
					.getElementsByXpath("//ul[@class='products-list product-list-in-box mypostlist']//li");

			int count = profilepostlists.size();

			if (count == 10) {

				Reporter.log("total count of the post in the homepage" + "-------" + count);
			} else {

				Reporter.log("failed the post count" + "------" + count);

			}

		} catch (Exception e) {

			Reporter.log("post list is not working" + e);
		}

	}

	public static void isDisplayed_PagenationFunctionalityLists() throws InterruptedException {

		Thread.sleep(2000);

		boolean pagenationbtn = DriverFunctions.getElementByXpath("//ul[@class='pagination']").isDisplayed();

		Reporter.log("pagenation is displayed or not " + "--------" + pagenationbtn);

		Thread.sleep(2000);

		List<WebElement> pagenationnum = DriverFunctions.getElementsByXpath("//ul[@class='pagination']//li//a");

		for (int i = 2; i < pagenationnum.size() - 2; i++) {

			pagenationnum.get(i);

			pagenationnum.get(i).click();

			Thread.sleep(2000);

			List<WebElement> profilepostlists1 = DriverFunctions
					.getElementsByXpath("//ul[@class='products-list product-list-in-box mypostlist']//li");

			int count1 = profilepostlists1.size();

			System.out.println(count1);

			Reporter.log("pagenation count of the page" + "--" + count1);

		}

	}

	public static void clickFirstButtonPagenation() {

		try {

			Thread.sleep(2000);

			WebElement firstbtn = DriverFunctions.getElementByXpath("//a[text()='First']");

			firstbtn.click();
		} catch (Exception e) {

			Reporter.log("click first button is not working" + e);
		}

	}

	public static void isDisplayed_searchButton() {

		boolean searchfield = DriverFunctions.getElementByXpath("//input[@placeholder='Search..']").isDisplayed();

		Reporter.log("search field is displayed or not" + "----------" + searchfield);

	}

	public static void enterSearchField(String title) {

		try {

			Thread.sleep(3000);

			WebElement searchfieldinput = DriverFunctions.getElementByXpath("//input[@placeholder='Search..']");

			searchfieldinput.clear();

			searchfieldinput.sendKeys(title);

		} catch (Exception e) {

			Reporter.log("enter search field is not working" + e);
		}

	}

	public static void clickSearchIcon() {

		try {

			Thread.sleep(2000);

			WebElement searchicon = DriverFunctions.getElementByXpath("//i[@class='fa fa-search']");

			searchicon.click();

		} catch (Exception e) {

			Reporter.log("click search icon is not working");
		}

	}

	public static void searchListsForTitle(String title) {

		try {

			Thread.sleep(4000);

			List<WebElement> searchlist = DriverFunctions.getElementsByXpath("//div[@class='product-info d1']//div");

			for (int i = 0; i < searchlist.size(); i++) {

				String searchlistname = searchlist.get(i).getText();

				if (searchlistname.contains(title)) {

					Reporter.log("Search field are working as excepted");

				} else {

					Reporter.log("Search field not working as excepted");
				}

			}

		} catch (Exception e) {

			Reporter.log("search list is not working" + e);

		}
	}

	public static void searchListsForKeySkill(String title) {

		try {

			Thread.sleep(4000);

			List<WebElement> searchlist = DriverFunctions
					.getElementsByXpath("//div[@class='col-md-11 p-1']/following::span[5]");

			for (int i = 0; i < searchlist.size(); i++) {

				String searchlistname = searchlist.get(i).getText();

				System.out.println(searchlistname);

				if (searchlistname.contains(title)) {

					Reporter.log("Search field are working as excepted");

				} else {

					Reporter.log("Search field not working as excepted");
				}

			}

		} catch (Exception e) {

			Reporter.log("search list is not working" + e);

		}

	}

	public static void searchListsForID(String title) {

		try {

			Thread.sleep(4000);

			List<WebElement> searchlist = DriverFunctions.getElementsByXpath(
					"//div[@class='validityclass']/following::span[@class='product-description'][1]");

			for (int i = 0; i < searchlist.size(); i++) {

				String searchlistname = searchlist.get(i).getText();

				if (searchlistname.equals(title)) {

					Reporter.log("Search field are working as excepted");

				} else {

					Reporter.log("Search field not working as excepted");
				}

			}
			
			DriverFunctions.getElementByXpath("//i[@class='fa fa-times']").click();
			

		} catch (Exception e) {

			Reporter.log("search list is not working" + e);

		}
	}

	public static void scrollupAndScrollDownPage() throws InterruptedException {

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) DriverFunctions.driver;
		js.executeScript("window.scrollBy(0,1000)", "");

		Thread.sleep(2000);

		JavascriptExecutor js1 = (JavascriptExecutor) DriverFunctions.driver;
		js1.executeScript("window.scrollBy(0,-1000)", "");

	}

	public static void clickProfilelinks() throws InterruptedException {

		Thread.sleep(4000);

		WebElement count = DriverFunctions.getElementByXpath("(//div[@class='countStyle'])[1]");

		String profilecount = count.getText();

		int profilecounts = Integer.parseInt(profilecount);

		Reporter.log("profile counts are :" + profilecount);

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("(//div[text()='Profiles'])[1]").click();

		Thread.sleep(3000);

		List<WebElement> lists = DriverFunctions
				.getElementsByXpath("//ul[@class='profileClass']//li//a[text()=' Set Availability ']");

		for (int i = 0; i < lists.size(); i++) {

			int counts = lists.size();

			if (counts == profilecounts) {

				Reporter.log("profile counts matched to the upload resume counts");

			}

		}

	}

	public static void clickSchedulelinks() throws InterruptedException {

		Thread.sleep(3000);

		WebElement count = DriverFunctions.getElementByXpath("(//div[@class='countStyle'])[2]");

		String sechdcount = count.getText();

		int sechdcounts = Integer.parseInt(sechdcount);

		Reporter.log("sechedule counts are :" + sechdcounts);

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("(//div[text()='Scheduled'])[1]").click();

		Thread.sleep(3000);

		List<WebElement> lists = DriverFunctions
				.getElementsByXpath("//ul[@class='profileClass']//li//a[text()=' Set Availability ']");

		for (int i = 0; i < lists.size(); i++) {

			int counts = lists.size();

			if (counts == sechdcounts) {

				Reporter.log("sechedule counts matched to the upload resume counts");

			}

		}

	}

	public static void clickSITlinks() throws InterruptedException {

		Thread.sleep(3000);

		WebElement count = DriverFunctions.getElementByXpath("(//div[@class='countStyle'])[3]");

		String sitcount = count.getText();

		int sitcounts = Integer.parseInt(sitcount);

		Reporter.log("sit counts are :" + sitcounts);

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("(//div[text()='SIT>6'])[1]").click();

		Thread.sleep(3000);

		List<WebElement> lists = DriverFunctions
				.getElementsByXpath("//ul[@class='profileClass']//li//a[text()=' Set Availability ']");

		for (int i = 0; i < lists.size(); i++) {

			int counts = lists.size();

			if (counts == sitcounts) {

				Reporter.log("sit counts matched to the upload resume counts");

			}

		}

	}

	public static void clickSelectedlinks() throws InterruptedException {

		Thread.sleep(3000);

		WebElement count = DriverFunctions.getElementByXpath("(//div[@class='countStyle'])[4]");

		String selectedcount = count.getText();

		int selectedcounts = Integer.parseInt(selectedcount);

		Reporter.log("select counts are :" + selectedcounts);

		Thread.sleep(2000);

		DriverFunctions.getElementByXpath("(//div[text()='Selected'])[1]").click();

		Thread.sleep(3000);

		List<WebElement> lists = DriverFunctions
				.getElementsByXpath("//ul[@class='profileClass']//li");

		for (int i = 0; i < lists.size(); i++) {

			int counts = lists.size();

			if (counts == selectedcounts) {

				Reporter.log("select counts matched to the upload resume counts");

			}else{
				
				Reporter.log("select counts not matched to the upload resume counts");

			}

		}

	}
	
	public static void clickHomeIcon() throws InterruptedException{
		
		Thread.sleep(3000);
		
		DriverFunctions.getElementByXpath("//a[text()='Home ']").click();
		
	}
	
	public static void enterJobLoction(String location) throws InterruptedException{
		
		Thread.sleep(3000);
		
		DriverFunctions.getElementByXpath("//input[@placeholder='Enter Job location']").sendKeys(location);
		
	}
	
	public static void enterMinimumSalary(String minsalary){
		
		DriverFunctions.getElementByXpath("//input[@placeholder='Minimum Salary*']").sendKeys(minsalary);
		
	}
	public static void enterMaximumSalary(String maxsalary){
		
		DriverFunctions.getElementByXpath("//input[@placeholder='Maximum Salary*']").sendKeys(maxsalary);
		
	}
	public static void enterVacany(String vacancy){
		
		DriverFunctions.getElementByXpath("//input[@placeholder='Enter vacancy']").sendKeys(vacancy);
		
	}
	
	public static void verifySitScoreAboveSix(){
		
		
		 List<WebElement> lists =    DriverFunctions.getElementsByXpath("//div[@class='status col-mod-2']");
		
	int prfcount = 	 lists.size();
	
	Reporter.log("profile counts"+"---------"+prfcount);
		 
		 
	    for(int i=0;i<lists.size();i++){
	    	
	    String data = 	lists.get(i).getText();
	    
	    if(data.equals("SIT 10")||data.equals("SIT 9")||data.equals("SIT 8")||data.equals("SIT 7")){
	    	
	    	Reporter.log("successfully displayed sit score above six"+"----"+data);
	    }else{
	    	
	    	Reporter.log("sit score displaying failed"+data);
	    }
	    	
	    }
		 
	}

}

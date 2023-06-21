package com.Screenit.version3.Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.CandidateProfilePage;
import com.Screenit.version3.Pages.DashBoardPage;
import com.Screenit.version3.Pages.LoginPage;

public class FilterAndScoreTestForIdFlow extends Initializer{
	
	@BeforeTest

	public void setup() throws IOException {

		initialize();

	}

	@Parameters({ "Emailid", "Password"} )
	@Test(priority = 1)

	public void loginFunctionality(String Emailid, String Password) throws InterruptedException {

		driver.get(envprop.getProperty("LOGINURL"));

		LoginPage.enterMail(Emailid);

		LoginPage.enterPassword(Password);

		LoginPage.clickSigninButton();

		LoginPage.VerifyNavigateToTheDashBoard();

	}


	@Parameters({"flow","text","text1","text2","screenshotName","screenshotName_1","screenshotName_2","sit","screenshotName_3"})
	@Test(priority=2)
	public void checkFilterByStatusForUploadedResume(String flow , String text,String text1,String text2,String screenshotName,String screenshotName_1,String screenshotName_2,String sit,String screenshotName_3) throws InterruptedException{
		
		DashBoardPage.selectIdOrJd(flow);
		
		DashBoardPage.clickProfileButton();
		
		CandidateProfilePage.verifyFilterByStatus(text);
		
		Screenshot.Takescrenshots(screenshotName);
	
		CandidateProfilePage.verifyFilterByStatus(text1);
		
		Screenshot.Takescrenshots(screenshotName_1);
		
		CandidateProfilePage.verifyFilterByStatus(text2);
		
		Screenshot.Takescrenshots(screenshotName_2);
		
		CandidateProfilePage.clickSearchClearButton();
		
		CandidateProfilePage.verifyFilterBySitScore(sit);
		
		Screenshot.Takescrenshots(screenshotName_3);
			
	}
	
	
	
	@AfterTest
	
	public void tearDown(){
		
		
		driver.quit(); 
		
	}

}

package com.Screenit.version3.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.DashBoardPage;
import com.Screenit.version3.Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTestForPostiveAndNegativeFlow extends Initializer {

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

	@Parameters({ "screenshotName_1" })
	@Test(priority = 2)

	public void HomepageFunctionality(String screenshotName_1) throws InterruptedException {

		DashBoardPage.isDisplayed_HomeIcon();

		DashBoardPage.isDisplayed_HomeButton();

		DashBoardPage.clickReportButton();

		DashBoardPage.isDisplayed_UploadButton();

		DashBoardPage.isDisplayed_UploadIcon();

		DashBoardPage.isDisplayed_BellNotificationIcon();

		DashBoardPage.isDisplayed_ProfileIcon();

		DashBoardPage.isDisplayed_ProfileIconArrow();

		Screenshot.Takescrenshots(screenshotName_1);

	}

	@Parameters({ "screenshotName_2" })
	@Test(priority = 3)

	public void PostFunctionality(String screenshotName_2) throws InterruptedException {

		DashBoardPage.isDisplayed_PostName();

		DashBoardPage.isDisplayed_ProfilePostLists();

		Screenshot.Takescrenshots(screenshotName_2);

	}

	@Parameters({ "screenshotName_3" })
	@Test(priority = 4)

	public void PagenationFunctionality(String screenshotName_3) throws InterruptedException {

		DashBoardPage.isDisplayed_PagenationFunctionalityLists();

		Screenshot.Takescrenshots(screenshotName_3);

	}

	@Parameters({ "title", "screenshotName_4" })
	@Test(priority = 5)

	public void SearchFunctionalityUsingTitle(String title, String screenshotName_4) throws InterruptedException {

		DashBoardPage.clickFirstButtonPagenation();

		DashBoardPage.isDisplayed_searchButton();

		DashBoardPage.enterSearchField(title);

		DashBoardPage.clickSearchIcon();

		DashBoardPage.searchListsForTitle(title);

		Screenshot.Takescrenshots(screenshotName_4);

	}

	@Parameters({ "keyskill", "screenshotName_5" })
	@Test(priority = 6)

	public void SearchFunctionalityUsingKeySkill(String keyskill, String screenshotName_5) throws InterruptedException {

		DashBoardPage.isDisplayed_searchButton();

		DashBoardPage.enterSearchField(keyskill);

		DashBoardPage.clickSearchIcon();

		DashBoardPage.searchListsForKeySkill(keyskill);

		Screenshot.Takescrenshots(screenshotName_5);
	}

	@Parameters({ "ID", "screenshotName_6" })
	@Test(priority = 7)

	public void SearchFunctionalityUsingUniqueID(String ID, String screenshotName_6) throws InterruptedException {

		DashBoardPage.isDisplayed_searchButton();

		DashBoardPage.enterSearchField(ID);

		DashBoardPage.clickSearchIcon();

		DashBoardPage.searchListsForID(ID);

		Screenshot.Takescrenshots(screenshotName_6);

	}

	@Test(priority = 8)

	public void ScrollPageFunctionality() throws InterruptedException {

		DashBoardPage.scrollupAndScrollDownPage();

	}

	@Parameters({ "screenshotName_7","screenshotName_8","screenshotName_9","screenshotName_10" })
	@Test(priority = 9)

	public void CheckPostCardCountsFunctionality(String screenshotName_7,String screenshotName_8,String screenshotName_9,String screenshotName_10) throws InterruptedException {

		DashBoardPage.clickProfilelinks();

		Screenshot.Takescrenshots(screenshotName_7);
		
		DashBoardPage.clickHomeIcon();

		DashBoardPage.clickSchedulelinks();

		Screenshot.Takescrenshots(screenshotName_8);
		
		DashBoardPage.clickHomeIcon();

		DashBoardPage.clickSITlinks();

		Screenshot.Takescrenshots(screenshotName_9);
		
		DashBoardPage.clickHomeIcon();

		DashBoardPage.clickSelectedlinks();

		Screenshot.Takescrenshots(screenshotName_10);
	
		DashBoardPage.clickHomeIcon();
		

	}

	@AfterTest

	public void tearDown() {

		driver.quit();

	}
}

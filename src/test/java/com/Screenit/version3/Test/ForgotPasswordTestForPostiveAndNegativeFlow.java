package com.Screenit.version3.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Screenit.version3.Initializer.Initializer;
import com.Screenit.version3.Initializer.Screenshot;
import com.Screenit.version3.Pages.ForgotPasswordPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgotPasswordTestForPostiveAndNegativeFlow extends Initializer {

	@BeforeMethod

	public static void setUp() throws IOException {

		initialize();

	}

	@Parameters({ "EmailId" ,"screenshotName"})
	@Test

	public void forgetPassword(String EmailId,String screenshotName ) throws InterruptedException {
		
		
		driver.get(envprop.getProperty("LOGINURL"));

		ForgotPasswordPage.clickForgotButton();
	
		ForgotPasswordPage.getUrlForForgotPassword();

		ForgotPasswordPage.enterEmail(EmailId);

		ForgotPasswordPage.clickSubmitButton();
		
		Screenshot.Takescrenshots(screenshotName);

		Thread.sleep(3000);

		String url = driver.getCurrentUrl();

		System.out.println(url);

		Thread.sleep(2000);

		if (url.equals("https://test.screenit.io/#/forget/password/success")) {

			WebElement successmsg = driver.findElement(By.xpath("//p[@class='lead success-text-align']"));

			String msg = successmsg.getText();

			System.out.println(msg);

			Reporter.log("forgetpassword succesfully" + "-----" + msg);

		} else {

			List<WebElement> errormsg = driver.findElements(By.tagName("p"));

			for (int i = 0; i < errormsg.size(); i++) {

				String message = errormsg.get(i).getText();

				if (message.equals("* Enter the valid email")) {

					System.out.println("please check the mail id");

					Reporter.log("Please check the mailid" + "-------" + message);

				} else if (message.equals("Invalid User")) {

					System.out.println("please check the existing mail id");

					Reporter.log("please check the existing mail id " + "-------" + message);
				}

			}

		}

	}

	@AfterMethod

	public void screenShotForFailedTestCase(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {

			try {

				TakesScreenshot screenshot = (TakesScreenshot) driver;

				File src = screenshot.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(src,
						new File(
								"C:\\Users\\TTS-USER\\workspace\\com.TestngFramework.ScreenitV3\\FailedForgotPageScreenShots\\"
										+ result.getName() + ".png"));

				System.out.println("Successfully captured a screenshot");

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}

		driver.quit();
	}

}

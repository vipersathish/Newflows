package com.Screenit.version3.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadMultipleResume {

	static WebDriver driver;

	@Parameters({ "Browser", "URL" })

	@BeforeTest

	public void setup(String Browser, String URL) {

		if (Browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (Browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (Browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(URL);

	}

	@Parameters({ "Emailid", "Password" })
	@Test(priority = 1)

	public void login(String Emailid, String Password) throws InterruptedException {

		WebElement user = driver.findElement(By.xpath("//input[@id='user_email']"));

		user.sendKeys(Emailid);

		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));

		pass.sendKeys(Password);

		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));

		btn.click();

		Thread.sleep(3000);

		String data = driver.getCurrentUrl();

		Assert.assertEquals(data, "https://test.screenit.io/#/dashboard_v3");

	}

	@Parameters({ "flow", "file" })
	@Test(priority = 2)

	public void UploadMultiResume(String flow, String file) throws InterruptedException, AWTException {

		Thread.sleep(2000);

		WebElement dropdown = driver.findElement(By.xpath("//select[@placeholder='Select Type']"));

		Select drop = new Select(dropdown);

		drop.selectByValue(flow);

		Thread.sleep(5000);

		WebElement profilebtn = driver.findElement(By.xpath("(//div[text()='Profiles'])[1]"));

		profilebtn.click();

		Thread.sleep(2000);

		WebElement uploadresumebtn = driver.findElement(By.xpath("//span[text()='Upload Resume']"));

		uploadresumebtn.click();

		Thread.sleep(2000);

		WebElement uploadbtn = driver.findElement(By.xpath("//label[@for='file1']"));

		uploadbtn.click();

		Thread.sleep(3000);

		Robot robot = new Robot();

		StringSelection filepath = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		
		WebElement submitbtn = driver.findElement(By.xpath("//button[text()=' Submit ']"));

		submitbtn.click();

		Thread.sleep(1000);

		WebElement text = driver.findElement(By.xpath("//div[text()='Candidate Resume uploaded successfully ']"));

		String uploadmessage = text.getText();

		Assert.assertEquals(uploadmessage, "Candidate Resume uploaded successfully");

	}
}

package com.Screenit.version3.Test;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditUploadJD {

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

	@Parameters({"flow", "year", "maxyears", "primaryskill", "secondaryskill", "location", "minsalary",
			"maxsalary", "vacany", "jobdescription", "remark" })
	@Test(priority = 2)
	public void EdituploadId(String flow , String year, String maxyears,
			String primaryskill, String secondaryskill, String location, String minsalary, String maxsalary,
			String vacany, String jobdescription, String remark) throws InterruptedException {

		
		Thread.sleep(2000);
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@placeholder='Select Type']"));

	Select drop = new Select(dropdown);
	
	drop.selectByValue(flow);

		WebElement postname = driver
				.findElement(By.xpath("(//ul[@class='products-list product-list-in-box mypostlist']//li[1]//span)[1]"));

		postname.click();

		WebElement editbtn = driver.findElement(By.xpath("//button[text()='Edit']"));

		editbtn.click();

		WebElement years = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));

		Select ss = new Select(years);

		ss.selectByVisibleText(year);

		WebElement maxyear = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

		Select sm = new Select(maxyear);

		sm.selectByVisibleText(maxyears);

		WebElement primaryskillbtn = driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[1]"));

		primaryskillbtn.click();

		Thread.sleep(2000);

		List<WebElement> primaryskillList = driver
				.findElements(By.xpath("(//ul[@class='multiselect__content'])[1]//span"));

		for (int i = 0; i < primaryskillList.size(); i++) {

			String text = primaryskillList.get(i).getText();

			if (text.contains(primaryskill)) {

				primaryskillList.get(i).click();

				break;
			}

		}

		WebElement secondaryskillbtn = driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[2]"));

		secondaryskillbtn.click();

		Thread.sleep(2000);

		List<WebElement> secondaryskillList = driver
				.findElements(By.xpath("(//ul[@class='multiselect__content'])[2]//span"));

		for (int i = 0; i < secondaryskillList.size(); i++) {

			String text = secondaryskillList.get(i).getText();

			if (text.contains(secondaryskill)) {

				secondaryskillList.get(i).click();

				break;
			}

		}

		Thread.sleep(3000);

		WebElement joblocation = driver.findElement(By.xpath("//input[@placeholder='Job Location*']"));
		
		joblocation.clear();

		joblocation.sendKeys(location);

		WebElement minimumsalary = driver.findElement(By.xpath("//input[@placeholder='Minimum Salary*']"));

		minimumsalary.clear();
		
		minimumsalary.sendKeys(minsalary);

		WebElement maximumsalary = driver.findElement(By.xpath("//input[@placeholder='Maximum Salary*']"));

		maximumsalary.clear();
		
		maximumsalary.sendKeys(maxsalary);

		WebElement entervacany = driver.findElement(By.xpath("//input[@placeholder='Job Vacancy*']"));

		entervacany.clear();
		
		entervacany.sendKeys(vacany);

		WebElement jd = driver.findElement(By.xpath("//textarea[@placeholder='Enter Job Description']"));

		jd.clear();
		
		jd.sendKeys(jobdescription);

		WebElement remarks = driver.findElement(By.xpath("//textarea[@placeholder='Enter Remarks']"));

		remarks.clear();
		
		remarks.sendKeys(remark);
		WebElement savebtn = driver.findElement(By.xpath("//input[@value='Save']"));

		savebtn.click();
           
		WebElement data = driver.findElement(By.xpath("//div[text()='ID updated successfully']"));

		String message = data.getText();

		System.out.println(message);

		Assert.assertEquals(message, "JD updated successfully");

		

	}
}

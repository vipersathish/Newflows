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
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditUploadID {

	static WebDriver driver;

	@Parameters({ "Browser", "URL" })

	@BeforeTest
   
	public void setup(String Browser , String URL){
		
		
		   if(Browser.equals("chrome"))	{
			   
			   WebDriverManager.chromedriver().setup();
			   
			    driver = new ChromeDriver();
			    
			    Reporter.log("Open chrome browser");
			   
			   
		   }else if(Browser.equals("firefox")){
			   
			   WebDriverManager.firefoxdriver().setup();
			   
			   driver = new FirefoxDriver();
			   
		   }else if (Browser.equals("edge")){
			   
			   WebDriverManager.edgedriver().setup();
			   
			   driver = new EdgeDriver();
			   
			   Reporter.log("Open edge browser");
		   }
		   
		   driver.manage().window().maximize();
		   
		   driver.manage().deleteAllCookies();
		   
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			driver.get(URL);
			
			  Reporter.log("Url should be"+"----"+URL);
			
		}
		
		@Parameters({"Emailid","Password"})
		@Test(priority=1)
		
		public void login(String Emailid , String Password) throws InterruptedException{
			
			
		WebElement user = 	driver.findElement(By.xpath("//input[@id='user_email']")) ;
		
		user.sendKeys(Emailid);
		
		Reporter.log("User Enter the valid Email"+"------"+Emailid);
		
		WebElement pass = 	driver.findElement(By.xpath("//input[@type='password']")) ;
		
		pass.sendKeys(Password);
		
		Reporter.log("User Enter the valid Password"+"------"+Password);
		
		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));
		
		btn.click();
		
		Reporter.log(" User Click the Login button");
		
		Thread.sleep(3000);
		
		String data = driver.getCurrentUrl();

		Assert.assertEquals(data, "https://demo.screenit.io/#/dashboard_v3");
		
	    Reporter.log("User should able to redirected to the homepage"+"-------"+data);
		
		}
		

	@Parameters({ "flow", "candyear", "candmonth", "primaryskill", "secondaryskill", "jobdescription", "remark" })
	@Test(priority = 2)
	public void EdituploadId(String flow, String candyear, String candmonth, String primaryskill, String secondaryskill,
			String jobdescription, String remark) throws InterruptedException {

		Thread.sleep(2000);

		WebElement dropdown = driver.findElement(By.xpath("//select[@placeholder='Select Type']"));

		Select drop = new Select(dropdown);

		drop.selectByVisibleText(flow);
		
		Reporter.log("User should able to selected the Post IDorJD"+"------"+flow);

		WebElement postname = driver
				.findElement(By.xpath("(//ul[@class='products-list product-list-in-box mypostlist']//li[1]//span)[1]"));

		postname.click();
		
		Reporter.log("User should able to click the first post ");

		WebElement editbtn = driver.findElement(By.xpath("//button[text()='Edit']"));

		editbtn.click();

		WebElement years = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));

		Select s = new Select(years);

		s.selectByVisibleText(candyear);
		
		Reporter.log("User Enter the Years"+"-------"+candyear);

		WebElement months = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

		Select sm = new Select(months);

		sm.selectByVisibleText(candmonth);
		
		Reporter.log("User Enter the months"+"-------"+candmonth);

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
		
		Reporter.log("User Enter the Primary skill"+"-------"+primaryskill);

		WebElement secondaryskillbtn = driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[2]"));

		secondaryskillbtn.click();

		List<WebElement> secondaryskillList = driver
				.findElements(By.xpath("(//ul[@class='multiselect__content'])[2]//span"));

		for (int i = 0; i < secondaryskillList.size(); i++) {

			String text = secondaryskillList.get(i).getText();

			if (text.contains(secondaryskill)) {

				secondaryskillList.get(i).click();

				break;
			}

		}
		
		Reporter.log("User Enter the Secondary skill"+"-------"+secondaryskill);

		WebElement jd = driver.findElement(By.xpath("//textarea[@placeholder='Enter Job Description']"));

		jd.clear();

		jd.sendKeys(jobdescription);
		
		Reporter.log("User Enter the Jobdescription"+"-------"+jobdescription);

		WebElement remarks = driver.findElement(By.xpath("//textarea[@placeholder='Enter Remarks']"));

		remarks.clear();

		remarks.sendKeys(remark);
		
		Reporter.log("User Enter the Remark"+"-------"+remark);
		
	
		WebElement savebtn = driver.findElement(By.xpath("//input[@value='Save']"));

		savebtn.click();
		
	Reporter.log("click the save button");
           
		WebElement data = driver.findElement(By.xpath("//div[text()='ID updated successfully']"));

		String message = data.getText();

		System.out.println(message);

		Assert.assertEquals(message, "ID updated successfully");
		
		Reporter.log("User should able to see"+"--------"+message);

	}

}

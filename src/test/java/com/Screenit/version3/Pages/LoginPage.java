package com.Screenit.version3.Pages;



import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.Screenit.version3.Initializer.DriverFunctions;


public class LoginPage {
	
	public static void enterMail(String Emailid){
		
		try{
		
		WebElement user = DriverFunctions.getElementByXpath("//input[@id='user_email']");

		user.sendKeys(Emailid);
		
		Reporter.log("Enter the Maild"+"---------"+Emailid);
		
		}catch (Exception e) {
			
			Reporter.log("Enter Email id is not working"+"---------"+e);
		}
	}
	
public static void enterPassword(String Password) throws InterruptedException{
		
	try{
		
		DriverFunctions.getElementByXpath("//input[@type='password']").sendKeys(Password);
		
		Reporter.log("Enter the Password"+"-----"+Password);
	}catch (Exception e) {
		Reporter.log("Enter password is not working"+"-----"+e);
	}

	}
	
	public static void clickSigninButton(){
		
		try{
		
		DriverFunctions.getElementByXpath("//button[@type='submit']").click();
		
		Reporter.log("click the submit button");
		}catch (Exception e) {
			
			Reporter.log("click sign is not working"+"-----"+e);
		}
	}
	
	public static void VerifyNavigateToTheDashBoard() throws InterruptedException{
		
		try{
		
		Thread.sleep(2000);
		
		String Url= DriverFunctions.driver.getCurrentUrl();
		
		Assert.assertEquals(Url,"https://demo.screenit.io/#/dashboard_v3");
		
		Reporter.log("succesfully login and navigate to the dashboard page"+Url);
		
		}catch(Exception e ){
			
			
			Reporter.log("navigation is not working"+"----"+e);
		}
	}


}

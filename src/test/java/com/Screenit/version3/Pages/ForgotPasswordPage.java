package com.Screenit.version3.Pages;

import org.testng.Assert;
import org.testng.Reporter;

import com.Screenit.version3.Initializer.DriverFunctions;

public class ForgotPasswordPage {
	
	
	
	public static void clickForgotButton() throws InterruptedException{
		
		try{
		
		Thread.sleep(2000);
		
		DriverFunctions.getElementByXpath("//span[text()='Forgot password?']").click();
		
		}catch (Exception e) {
			
			Reporter.log("click forgotbutton is not working"+"----"+e);
		}
		
	}
	
	public static void enterEmail(String EmailId) throws InterruptedException{
		
		Thread.sleep(2000);
		
		try{
		
		DriverFunctions.getElementByXpath("//input[@id='user_email']").sendKeys(EmailId);
		
		}catch (Exception e) {
	
		Reporter.log("EnterEmailId is not working"+e);
		}
		
	}
	
	public static void clickSubmitButton() throws InterruptedException{
		
		Thread.sleep(2000);
		
		try{
		
		DriverFunctions.getElementByXpath("//button[@type='submit']").click();
		
		}catch (Exception e) {
			
			Reporter.log("click submit button is not working"+e);
		}
	}
	
	public static void getUrlForForgotPassword() throws InterruptedException{
	
	Thread.sleep(3000);

	String Url = DriverFunctions.driver.getCurrentUrl();

	System.out.println(Url);

	Assert.assertEquals(Url, "https://demo.screenit.io/#/forget_v3/password");

	}
}

package com.Screenit.version3.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.Screenit.version3.Initializer.DriverFunctions;


public class SignupPage {

	public static void clickSignupButton() throws InterruptedException {

		
		try
		{
		
		Thread.sleep(3000);

		DriverFunctions.getElementByXpath("//span[text()='Sign Up']").click();

		Reporter.log("click the signup button");
		}catch (Exception e) {
		
			Reporter.log("signup button is not working"+"----"+e);
		}
	}

	public static void emailField_isDisplayed() throws InterruptedException {

		
		try{
			
		
		Thread.sleep(3000);

	boolean Emailfield_isdisplayed = 	DriverFunctions.getElementByXpath("//input[@id='__BVID__50']").isDisplayed();
		
		System.out.println(Emailfield_isdisplayed);

		Reporter.log("Email field is displayed or not" + "----" + Emailfield_isdisplayed);

		Thread.sleep(3000);
		
		}catch (Exception e) {
			
			Reporter.log("Emailfield is not displayed"+"---"+e);
		}

	}
	
	public static void mobileNumberfield_isdisplayed(){
		
try{
		 Boolean MobileNumberfield_isdisplayed  =   DriverFunctions.getElementByXpath("//input[@type='tel']").isDisplayed();
		 
			System.out.println(MobileNumberfield_isdisplayed);
			
			Reporter.log("Email field is displayed or not"+"----"+MobileNumberfield_isdisplayed);
			
		   Thread.sleep(2000);
		   
}catch (Exception e) {
	
	// TODO: handle exception
	
	Reporter.log("mobile number field is not displayed"+"---"+e);
}
		
	}
	
	public static void enterEmail(String Emailid){
		
		
		try{
		 WebElement emailid =   DriverFunctions.getElementByXpath("//input[@id='__BVID__50']");
		 
		 emailid.sendKeys(Emailid);
		 
		}catch (Exception e) {
			
			// TODO: handle exception
			
			Reporter.log("Emailid is not working"+"---"+e);
		}
		
	}
	
	
public static void enterMobileNumber(String mobilenumber){
		
		
		try{
		 WebElement mobilenum =   DriverFunctions.getElementByXpath("//input[@type='tel']");
		 
		 mobilenum.sendKeys(mobilenumber);
		 
		}catch (Exception e) {
			
			// TODO: handle exception
			
			Reporter.log("mobile number field is not working"+"---"+e);
		}
		
	}


public static void EnterSignUpButton(){
	
	try{
	DriverFunctions.getElementByXpath("//button[text()='Sign Up']").click();
	
	}catch (Exception e) {
		
		Reporter.log("sign up button is not working"+"---"+e);
}

}

	

}

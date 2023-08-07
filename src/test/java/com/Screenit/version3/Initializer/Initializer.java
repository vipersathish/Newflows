package com.Screenit.version3.Initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.Reporter;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer {
	
		
	/**
	 * @author 
	 * @date
	 * @purpose environment variable declared
	 * 
	 *
	 */
	
       

	public static FileInputStream envfis = null;
	
	public static Properties envprop= null;
	
	/**
	 * 
	 * 
	 */
	/**
	 * 
	 * 
	 * @purpose locator variables declared
	 */
	
	public static FileInputStream locatorfis = null;
	
	public static Properties locatorprop = null;
	
	
	
	/**

	 */
	
	public static WebDriver driver = null;
	

	/**
	 * 
	 * 
	 * @throws IOException
	
	 */
	
	
	public static void initialize() throws IOException{
		
		

		
		 envfis = new FileInputStream(new File("configure\\env.properties"));
		
		 envprop = new Properties();
		
		envprop.load(envfis);

		
		
		if(envprop.get("BROWSER").equals("chrome")){
			
		
			WebDriverManager.chromedriver().setup();
			
		
			driver= new ChromeDriver();
			
			Reporter.log("The chrome browser is open now");
			
		}else if(envprop.get("BROWSER").equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
			
		}else if(envprop.get("BROWSER").equals("ie")){
			
			WebDriverManager.iedriver().setup();
		
			driver = new InternetExplorerDriver();
			
			
		}
	
		
		driver.manage().window().maximize();
		
		Reporter.log("The browser is maximize");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
        
//		
		
	}
	
	
	
		
		
}
		
		

	

	
		
		
	
		
		
		
	
	


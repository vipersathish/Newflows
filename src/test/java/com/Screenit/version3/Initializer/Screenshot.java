package com.Screenit.version3.Initializer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;


public class Screenshot extends Initializer{
	
	
		
		
		public static void Takescrenshots(String screenshotName) throws InterruptedException{
			
			
		Thread.sleep(3000);
				
				try{
					
					File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				//	File src= screenshot.getScreenshotAs(OutputType.FILE);
					
				File screen = 	new File("C:\\Users\\TTS-USER\\AppData\\Local\\Temp"+screenshotName+"---"+timestamp()+".png");
					
					FileUtils.copyFile(screenshot, screen);
					
					 Reporter.log("<a href='"+ screen.getAbsolutePath() + "'> <img src='"+ screen.getAbsolutePath() + "' height='100' width='100'/> </a>");
	                
				//	 System.out.println( src);
					 
					 
					
					System.out.println("Successfully captured a screenshot");
					
					
					
				}catch (Exception e){
					
					System.out.println("Exception while taking screenshot "+e.getMessage());
				} 
		
		
		}
		

	    public static String timestamp() {
	    	
	        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	    }
		
		
	

	

}

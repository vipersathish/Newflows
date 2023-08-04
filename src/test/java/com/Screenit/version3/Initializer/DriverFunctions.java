
package com.Screenit.version3.Initializer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DriverFunctions extends Initializer{

	

	public static void getElementById() {
          
	
	}

	public static List<WebElement> getElementsByTagName(String tagname) {

		try{
	return	driver.findElements(By.tagName(tagname));
		
		}catch (Exception e) {
			
		System.out.println(e);
		}
		
		return null ;
	}

   
	public static WebElement getElementByXpath(String xpath) {
		try{
	return	driver.findElement(By.xpath(xpath));
	}catch(Exception e){
		
		System.out.println(e.getLocalizedMessage());
	}
  return null;
	}
	
	
	public static List<WebElement> getElementsByXpath(String lists){
		
		try{
	return	driver.findElements(By.xpath(lists));
		
	}catch(Exception e){
		
		System.out.println(e.getLocalizedMessage());
	}
		return null;
	}

	
	

}

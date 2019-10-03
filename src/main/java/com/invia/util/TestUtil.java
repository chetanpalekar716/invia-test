package com.invia.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.invia.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static void clickAction(WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	public static void doubleClickAction(WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();	
	}
	
	public void setCalendarDate(String given_date_string) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		
	}
	
	public static void selectDropDownByIndex(WebElement element,int index){
		
		Select slct_drpdwn = new Select(element);
		slct_drpdwn.selectByIndex(index-1);
	}
}

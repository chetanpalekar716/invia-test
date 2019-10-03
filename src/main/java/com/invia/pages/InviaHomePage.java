package com.invia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.invia.base.TestBase;
import com.invia.util.TestUtil;

public class InviaHomePage extends TestBase{

	@FindBy(xpath = ".//button[@class='cookiebot__button cookiebot__button--ok']")
	@CacheLookup
	private WebElement cookieAcceptButton;

	@FindBy(xpath = ".//label[@class='item-hotel']")
	@CacheLookup
	private WebElement hotel_city;

	@FindBy(xpath = ".//input[@id='base[searchTerm]']")
	@CacheLookup
	private WebElement base_search_term;

	@FindBy(xpath = ".//span[text()='Anreise']//preceding-sibling::input[@class='datepicker-input datepicker-input-start']")
	@CacheLookup
	private WebElement anreise_calendar;

	@FindBy(xpath = ".//div[@class='datepicker-layer start-input']//span[@class='month-button month-button-next icon-arrow-right-bold']")
	@CacheLookup
	private WebElement anreise_calendar_arrow_right;

	@FindBy(xpath = ".//div[@class='month month-10 year-2019']//td[contains(text(),'25')]")
	@CacheLookup
	private WebElement anreise_date;

	@FindBy(xpath = ".//span[text()='Abreise']//preceding-sibling::input[@class='datepicker-input datepicker-input-end']")
	@CacheLookup
	private WebElement abreise_calendar;

	@FindBy(xpath = ".//div[@class='datepicker-layer end-input']//span[@class='month-button month-button-next icon-arrow-right-bold']")
	@CacheLookup
	private WebElement abreise_calendar_arrow_right;

	@FindBy(xpath = ".//div[@class='month month-10 year-2019']//td[contains(text(),'29')]")
	@CacheLookup
	private WebElement abreise_date;

	@FindBy(xpath = ".//div[@class='_input-box _input-box-icon-set _input-box-size-1 _input-box-traveller traveller']")
	@CacheLookup
	private WebElement number_of_travellers;

	@FindBy(xpath = ".//select[@name='base[numberOfRooms]']")
	@CacheLookup
	private WebElement number_of_rooms_dropdown;

	@FindBy(xpath = ".//select[@name='base[numberOfRooms]']/ancestor::div/following-sibling::div//span[text()='Angebote suchen']")
	@CacheLookup
	private WebElement angebote_suchen_button;

	public InviaHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectBookingType(){
		cookieAcceptButton.click();
		hotel_city.click();
	}

	public void searchArea(String area){

		base_search_term.sendKeys(area);
		driver.findElement(By.xpath(".//a[@data-region.name='"+area+"']")).click();
	}

	public void setAnreiseDate(String anreise_given_date) {
		
		TestUtil.clickAction(anreise_calendar);
		anreise_calendar_arrow_right.click();
		anreise_date.click();

	}

	public void setAbreiseDate(String anreise_given_date) {
		abreise_date.click();
	}
	public void selectTravellers(int erwachsene, int kinder) {
		number_of_travellers.click();
		number_of_travellers.click();

	}
	public void selectNumberOfRooms(int number) {
		TestUtil.selectDropDownByIndex(number_of_rooms_dropdown, number);
	}

	public HotelSearchResultsPage submitSearch() {
		
		TestUtil.doubleClickAction(angebote_suchen_button);	
		return new HotelSearchResultsPage();
	}

}

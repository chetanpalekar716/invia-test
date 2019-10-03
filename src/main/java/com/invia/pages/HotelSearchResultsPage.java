package com.invia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.invia.base.TestBase;
import com.invia.util.TestUtil;

public class HotelSearchResultsPage extends TestBase{

	@FindBy(xpath = ".//span[@class='select-icon hc-icon-star-50']")
	@CacheLookup
	private WebElement five_stars_icon;	

	@FindBy(xpath = ".//span[@class='hc-icon-smiley-5 icon']")
	@CacheLookup
	private WebElement five_rating_icon;	

	@FindBy(xpath = ".//li[text()='Preis']")
	@CacheLookup
	private WebElement preis_sort;


	public HotelSearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public void setSterne(int stars) {

		switch(stars) {

		case 1: 
			break;

		case 2: 
			break;

		case 3: 
			break;

		case 4: 
			break;

		case 5:  //five_stars_icon.click();
		TestUtil.clickAction(five_stars_icon);
		break;

		default:
			break;
		}
	}

	public void setBewertung(int ratings) {

		switch(ratings) {

		case 1: five_rating_icon.click();
		break;

		case 2: 
			break;

		case 3: 
			break;

		case 4: 
			break;

		case 5:  
			break;

		default:
			break;
		}
	}

	public void sortPreis(String order) {
		switch(order) {
		case "ascending": TestUtil.doubleClickAction(preis_sort);
			break;

		case "descending": preis_sort.click(); 
			
			break;
		}

	}
}

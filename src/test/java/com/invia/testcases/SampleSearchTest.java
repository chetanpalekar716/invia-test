package com.invia.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.invia.base.TestBase;
import com.invia.pages.HotelSearchResultsPage;
import com.invia.pages.InviaHomePage;

public class SampleSearchTest extends TestBase{

	InviaHomePage homePage;

	public SampleSearchTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new InviaHomePage();	
	}

	@Test
	public void sampleSearchTest() {
		
		homePage.selectBookingType();
		homePage.searchArea("Madrid");
		homePage.setAnreiseDate("25.11.2019");
		homePage.setAbreiseDate("29.11.2019");
		homePage.selectTravellers(2,0);
		homePage.selectNumberOfRooms(2);
		HotelSearchResultsPage searchResultsPage = homePage.submitSearch();
		searchResultsPage.setSterne(5);
		searchResultsPage.setBewertung(5);
		searchResultsPage.sortPreis("descending");
		
	}
}

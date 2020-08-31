package com.gripeventtask.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import com.gripeventtask.pageObjects.BasePage;
import com.gripeventtask.pageObjects.FlightSearchPage;
import com.gripeventtask.testCases.BasePageTest;

public class FlightSearchPageTest extends BasePageTest{
		
	/* Verify that it does not let you proceed if there are insufficient information. Example: This test does not enter a departing date*/
	@Test()
	public void cannotProceedSearchWithInsufficientInformation() throws InterruptedException {
		FlightSearchPage flightSearch = new FlightSearchPage(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//logger.info("Error Message for insufficient data");
		flightSearch.clickFlightsTab()
				.clickRoundTripTab()
				.searchForDepartingAirport("London")
				.searchForArrivingAirport("Raonoke")
				.FlightSearchPage_openDCalendarSelection();
		logger.info("Flight Search Successful");
		
	}
	
	
	


}

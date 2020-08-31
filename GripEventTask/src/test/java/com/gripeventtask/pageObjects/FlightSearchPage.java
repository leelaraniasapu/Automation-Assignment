package com.gripeventtask.pageObjects;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FlightSearchPage extends BasePage{
	
	WebDriver driver;
	
	public FlightSearchPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}

	
	/* Web elements for Flight Search Page*/
	
	By flightsTab = By.xpath("//div[contains(@class,'uitk-tabs-container')]//li[2]//a[1]");
	By roundtriptab = By.xpath("//div[contains(@class,'uitk-tabs-inner-container')]//li[1]");
	By flyingFromBox = By.xpath("//div[contains(@class,'uitk-layout-grid uitk-layout-grid-gap-three uitk-layout-grid-columns-small-1 uitk-layout-grid-columns-medium-2 Location locationWithSwap')]//div[1]//div[1]//div[1]//div[1]//button[1]");
	By departingAirport = By.xpath("//input[@id='location-field-leg1-origin']");
	By dAirportName = By.xpath("//div[@id='location-field-leg1-origin-menu']/div[2]/ul/li[2]/button/div/div[1]/span/strong");
	By searchResults = By.xpath("//ul[@id='typeaheadDataPlain']");
	By resultsTagName = By.tagName("a");
	By goingToBox = By.xpath("//div[@class='uitk-layout-grid-item uitk-layout-grid-item-columnspan-small-4 uitk-layout-grid-item-columnspan-medium-6 uitk-layout-grid-item-columnspan-large-8']//div[2]//div[1]//div[1]//div[1]//button[1]");
	By arivingAirport = By.xpath("//input[@id='location-field-leg1-destination']");
	By aAirportName = By.xpath("//div[@id='location-field-leg1-destination-menu']/div[2]/ul/li[4]/button");
	By departingDateBox = By.xpath("//button[@id='d1-btn']");
	By departingCalendar = By.xpath("//div[@class='uitk-calendar']//div[1]//table[1]//tbody[1]//tr[3]//td[3]//button[1]");
	By departingDateDone = By.xpath("//button[@class='uitk-button uitk-button-small uitk-button-has-text uitk-button-primary uitk-flex-item uitk-flex-shrink-0 dialog-done']");
	By returnDateBox = By.xpath("//button[@id='d1-btn']");
	By returnCalendar = By.xpath("//div[@class='uitk-calendar']//div[1]//table[1]//tbody[1]//tr[3]//td[3]//button[1]");
	By returnDateDone = By.xpath("//button[@class='uitk-button uitk-button-small uitk-button-has-text uitk-button-primary uitk-flex-item uitk-flex-shrink-0 dialog-done']");
	By errorMessage = By.xpath("//div[@class='alert alert-error validation-alert']");
	By dateTagName = By.tagName("button");
	By searchButton = By.xpath("//button[@type='submit']");
	
	/* Click on 'flights' tab */
	public FlightSearchPage clickFlightsTab() {
		driver.findElement(flightsTab).click();
		return this;
	}

	/* Click on 'Round Trip' option */
	public FlightSearchPage clickRoundTripTab() {
		driver.findElement(roundtriptab).click();
		return this;
	}

	/* Search for an airport in the 'Flying from' text box */
	public FlightSearchPage searchForDepartingAirport(String departingCity) {
		//Start with partial search
		//driver.findElement(flyingFromBox).clear();
		driver.findElement(flyingFromBox).click();
		driver.findElement(departingAirport).sendKeys(departingCity);
		driver.findElement(dAirportName).click();
		return this;
	}

	/* Search for an airport in the 'Going to' text box */
	public FlightSearchPage searchForArrivingAirport(String arrivalCity) throws InterruptedException {
		//driver.findElement(goingToBox).clear();
		driver.findElement(goingToBox).click();
		driver.findElement(arivingAirport).sendKeys(arrivalCity);
		driver.findElement(aAirportName).click();
		Thread.sleep(1000);
		return this;
	}

	/* Click on a result from the search suggestion list based on matching text */
	public FlightSearchPage clickFromAirportSuggestionsList(String fullAirportName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
		//Get the element of the entire suggestion list, then the tag name of all the individual results
		List<WebElement> results = driver.findElement(searchResults).findElements(resultsTagName);
		for(WebElement result : results) {
			if(result.getText().contains(fullAirportName)) {
				result.click();
				break;
			}
		}
		return this;
	}

	/* Click on the calendar text box to open the calendar list */
	public void FlightSearchPage_openDCalendarSelection() throws InterruptedException {
		
		driver.findElement(departingDateBox).click();
		
		driver.findElement(departingCalendar).click();
		
		driver.findElement(departingDateDone).click();
		
		driver.findElement(returnDateBox).click();
		
		driver.findElement(returnCalendar).click();
		
		driver.findElement(returnDateDone).click();
		
		driver.findElement(searchButton).click();
		
	}
	
		
	/* Click on a date based on the entered number 
	public FlightSearchPage chooseDate(String day) {
		List<WebElement> dates = driver.findElement(departingCalendar).findElements(dateTagName);
		for(WebElement date : dates) {
			if(date.getAttribute("data-day").equals(day)){
				date.click();
				break;
			}
		}
		return this;
	}*/

	/* Click the 'Advanced options' drop-down*/ 
	/*public FlightSearchPage clickAdvancedOptions() {
		driver.findElement(advancedOptionsTab).click();
		return this;
	}*/

	/* Click the 'Preferred class' drop-down 
	public FlightSearchPage selectDifferentClass(String value) {
		Select preferredClass = new Select(driver.findElement(preferredClassDropdown));
		preferredClass.selectByValue(value);
		return this;
	}*/

	/* Return the text of the selected flight class 
	public String selectedOption() {
		return new Select(driver.findElement(preferredClassDropdown)).getFirstSelectedOption().getText();
	}*/

	/* Check that the error message is displayed if a user doesn't fill out the required fields */
	public boolean errorMessageDisplayed() {
		return driver.findElement(errorMessage).isDisplayed();
	}

	/* Click on 'Search' button */
	public void FlightSearchPage_clickOnSearchButton() {
		driver.findElement(searchButton).click();
		
	}

	/* Check that the search results page finished loading 
	public boolean finishedLoading() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loadedFlights));
		return driver.findElement(loadedFlights).isDisplayed();
	}*/

	/* When a user searches for a flight, an another window may open. This method closes the respective window */
	public FlightSearchPage closePopup() {
		try {
			String parentWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			for(String newWindow : windows) {
				if(!newWindow.equals(parentWindow)) {
					driver.switchTo().window(newWindow);
					driver.close();
				}
			}
			driver.switchTo().window(parentWindow);
		}catch(Exception e) {

		}
		return this;
	}


}
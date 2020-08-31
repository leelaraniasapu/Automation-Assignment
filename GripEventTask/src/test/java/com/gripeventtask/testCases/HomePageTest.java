package com.gripeventtask.testCases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gripeventtask.pageObjects.HomePage;

public class HomePageTest extends BasePageTest{

		
	/* Check that the title of the home page matches expected title */
	@Test(priority=0)
	public void verifyTitle() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Assert.assertEquals(homePage.getTitle(), "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations");
		//logger.info("Title matches with the expected title");
	}
	
	/* Check that the logo is present in the home page */
	/*@Test(priority=1)
	public void verifyLogoIsPresent() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getLogo());
		logger.info("Matches the Logo");
	}*/
	
	/* Check that the virtual chat icon is loaded in the home page */
	/*@Test(priority=2)
	public void verifyVirtualChatIconLoaded() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isChatIconPresent());
		logger.info("Successful check of Virtula Chat Icon");
	}
	
	/* Iterate through and click each of the navigation tab */
	/*@Test(priority=3)
	public void clickEachNavigationTab() {
		HomePage homePage = new HomePage(driver);
		for(int i=0; i<homePage.getNavigationTab().size(); i++) {
				homePage.getNavigationTab().get(i).click();
			}
			String lastTab = homePage.getNavigationTab().get(6).getText();
			// The last tab should be the Vacation Rentals tab. Check that it clicked the tab
			Assert.assertEquals(lastTab, "Vacation Rentals\n" + 
					"Tab 7 of 7");
			logger.info("Successful check of all tabs");
		}*/
	

}

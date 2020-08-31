package com.gripeventtask.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.gripeventtask.pageObjects.BasePage;

public class HomePage extends BasePage{

	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	/* Web elements for Home Page */
		
	By expediaLogo = By.xpath("//*[contains(@class, 'logo')]/img");
	By navigationTab = By.cssSelector(".tabs.cf.col");
	By individualTabs = By.cssSelector(".tab");
	By iframe = By.id("web-messenger-container");
	By virtualChatIframe = By.cssSelector("#web-messenger-container");
	By virtualChatIcon = By.xpath("//div[contains(@class,'messenger-button-icon')]//img");
	By virtualChatHeader = By.xpath("//div[@id='header'][contains(text(), 'How can we help?')]");

	
	
	public String getTitle() throws InterruptedException {
		//System.out.println("In Home page ");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//System.out.println("The Page Title - " +driver.getTitle());
		return driver.getTitle();
	}

	/* Check if Expedia-Logo is displayed */
	public boolean getLogo() {
		return driver.findElement(expediaLogo).isDisplayed();
	}

	/* Check if chat icon loads */
	/*public boolean isChatIconPresent() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(virtualChatIframe));
		return driver.findElement(virtualChatIframe).isDisplayed();
	}*/

	/* Get all the elements of the different navigation buttons */
	/*public List<WebElement> getNavigationTab(){
		return driver.findElement(navigationTab).findElements(individualTabs);
	}*/


}
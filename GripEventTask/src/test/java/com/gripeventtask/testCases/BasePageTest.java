package com.gripeventtask.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gripeventtask.pageObjects.HomePage;
import com.gripeventtask.utilities.ReadConfig;

public class BasePageTest{

ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger; //Added logger
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("Expedia"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		
		if (br.equals("firefox")) {
			// Opens the FireFox Browser
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers/geckodriver.exe" );
			driver = new FirefoxDriver();
			
		}

		else if (br.equals("chrome")) {
			// Opens the Chrome Browser
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe" );
			driver=new ChromeDriver();
						
		}
		
		else if (br.equals("ie")) {
			// Opens the IE Browser
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//Drivers/IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
			
			//return driver;
		}
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test()
	public void verifyTitle() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.getTitle(), "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations");
		logger.info("Title matches with the expected title");
	}
	
	/* Check that the logo is present in the home page */
	@Test()
	public void verifyLogoIsPresent() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.getLogo());
		logger.info("Matches the Logo");
	}
	/*@BeforeClass
	public WebDriver setup()
	{
		logger = Logger.getLogger("Expedia"); //Added logger
		PropertyConfigurator.configure("Log4j.properties");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe" );
		//driver=new ChromeDriver();
		// Global implicit Wait
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Base Page Test");
		return driver;
	}*/
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
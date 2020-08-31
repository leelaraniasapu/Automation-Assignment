package com.gripeventtask.testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.gripeventtask.pageObjects.HomePage;
import com.gripeventtask.pageObjects.SignInPage;

public class SignInPageTest extends BasePageTest{
	

	/* Navigate to SignIn screen from Home page*/
	/*@BeforeClass()
	public void navigateToLoginScreen() {
		SignInPage signinPage = new SignInPage(driver);
		logger.info("SignIn Page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		signinPage.navigateToLoginScreen();
		//Assert.assertTrue(signinPage.isLoginScreenPresent());
		logger.info("Navigate to Login Screen");
		}*/

	/* Verify that the Sign In with Google option is present */
	/*@Test(priority=0)
	public void verifyGoogleLoginLinkDisplayed() {
		SignInPage login = new SignInPage(driver);
		Assert.assertTrue(login.isGoogleSigninLinkPresent());
		logger.info("Signin with Google Account");
	}*/

	/* Verify that the Sign In with FaceBook option is present */
	/*@Test(priority=1)
	public void verifyFacebookLoginLinkDisplayed() {
		SignInPage login = new SignInPage(driver);
		Assert.assertTrue(login.isFacebookSigninLinkPresent());
		logger.info("Signin with Facebook Account");
	}*/

	/* Verify clicking on Forgot Password link loads reset password screen */
	/*@Test(priority=2)
	public void clickForgotPasswordLink() {
		SignInPage login = new SignInPage(driver);
		login.clickForgotPassword();
		logger.info("Clicked on Forgot Password button");
		Assert.assertTrue(login.didResetPasswordScreenLoad());
		login.clickBackButton();
		logger.info("Clicked on Back button");
	}*/

	/* Verify successful login by providing valid credentials */
	@Test()
	public void navigateToLoginScreen() throws InterruptedException {
		//SignInPage login = new SignInPage(driver);
		SignInPage signinPage = new SignInPage(driver);		
		logger.info("SignIn Page");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		signinPage.navigateToLoginScreen();
		//Assert.assertTrue(signinPage.isLoginScreenPresent());
		logger.info("Navigate to Login Screen");
		
		signinPage.typeEmailAddress(username);
		logger.info("User provided"); 
		
		signinPage.typePassword(password);
		logger.info("Password provided");
		
		signinPage.clickLoginButton();
		logger.info("Login in Clicked");
		/*login.typeEmailAddress("")
			.typePassword("")
			.uncheckKeepSignedIn()
			.clickLoginButton();*/
		logger.info("Login Successful");
		try {
			Assert.assertTrue(signinPage.isLoginSuccessful());
			logger.info("Login successful, returning to home page");
		} catch(Exception e) {
			Assert.assertTrue(signinPage.didRecaptchaAppear());
			logger.debug("Login successful, but recaptcha human verification pop-up appeared");
		}
	}


}

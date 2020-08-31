package com.gripeventtask.pageObjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage{
	
	public WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}
		
	/* Web elements for SignIn Page*/
	
	
	By headerSignin = By.xpath("//div[@id='gc-custom-header-nav-bar-acct-menu']/button/div");
	By signinLink = By.xpath("//div[@id='gc-custom-header-nav-bar-acct-menu']/div/div/div/div/div[1]/div/div/a[1]");
	By loginid = By.xpath("//input[@id='signin-loginid']");
	By password = By.xpath("//input[@id='signin-password']");
	By signinButton = By.xpath("//button[@id='submitButton']");
	By signInWithGoogle = By.cssSelector("#gss-signin-login-google-button");
	By signInWithFacebook = By.cssSelector("#gss-signin-login-facebook-button");
	By forgotPassword = By.cssSelector("#gss-go-to-forgot-password");
	By resetPasswordButton = By.id("gss-forgot-password-submit");
	By backButton = By.xpath("//span[@id='gss-go-back-from-forgot-password']//span[@class='gss-go-back-label'][contains(text(),'Back')]");
	By keepMeSignedInCheckbox = By.cssSelector("#gss-keep-signin-check");
	By greetingUserText = By.xpath("//span[contains(@class,'nonArrangedUser')][contains(text(), 'Welcome')]");
	By recaptchaChallenge = By.xpath("//iframe[@title='recaptcha challenge']");
	
	public SignInPage navigateToLoginScreen() {
		driver.findElement(headerSignin).click();
		driver.findElement(signinLink).click();
		return this;
	}

	/*public boolean isLoginScreenPresent() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(signinButton));
		return driver.findElement(signinButton).isDisplayed();
	}*/
	
	/* Check that the Sign In with Google option is displayed */
	public boolean isGoogleSigninLinkPresent() {
		return driver.findElement(signInWithGoogle).isDisplayed();
	}

	/* Check that the Sign In with FaceBook option is displayed */
	public boolean isFacebookSigninLinkPresent() {
		return driver.findElement(signInWithFacebook).isDisplayed();
	}

	/* Click on Forgot Password button */
	public SignInPage clickForgotPassword() {
		driver.findElement(forgotPassword).click();
		return this;
	}

	/* Check that the password reset screen loaded */
	public boolean didResetPasswordScreenLoad() {
		return driver.findElement(resetPasswordButton).isDisplayed();
	}

	/* Click on back button to go back to the main login screen */
	public SignInPage clickBackButton() {
		driver.findElement(backButton).click();
		return this;
	}

	/* Get the email text box element and type entered email */
	public SignInPage typeEmailAddress(String email) {
		driver.findElement(loginid).clear();
		driver.findElement(loginid).sendKeys(email);
		return this;
	}

	/* Get the password text box element and type entered password */
	public SignInPage typePassword(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
		return this;
	}

	/* If the Keep me signed in check box is checked, un-check it */
	public SignInPage uncheckKeepSignedIn() {
		if(driver.findElement(keepMeSignedInCheckbox).isSelected()) {
			driver.findElement(keepMeSignedInCheckbox).click();
		}
		return this;
	}

	/* Click the Sign in button */
	public SignInPage clickLoginButton() {
		driver.findElement(signinButton).click();
		return this;
	}
	
	/* Check the Login Success*/
	public boolean isLoginSuccessful() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(signinButton));
		return driver.findElement(greetingUserText).isDisplayed();
	}

	/* When a user successfully logs in, the human verification waits until pop-up appears */
	public boolean didRecaptchaAppear() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(recaptchaChallenge));
		return driver.findElement(recaptchaChallenge).isDisplayed();
	}

	
}
	

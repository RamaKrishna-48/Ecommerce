package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.basePage.testBase;

public class loginPage extends testBase {
	
	
	@FindBy(xpath = "//a[normalize-space()='Log in']")
	WebElement clickOnLoginButtonEnterToLoginPage;

	@FindBy(xpath = "//*[text()='Welcome, Please Sign In!']")
	WebElement validatePleaseSignInText;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement enterUserName;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement enterPassword;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement clickOnLoginButtonEnterToHomePage;

	public loginPage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	

	public void validateLoginPage() {
		String actual=validatePleaseSignInText.getText();
		String Expected="Welcome, Please Sign In!";
		Assert.assertEquals(Expected, actual);
		
		
	}

	public homePage login(String un, String pwd) {
		clickOnLoginButtonEnterToLoginPage.click();
		enterUserName.sendKeys(un);
		enterPassword.sendKeys(pwd);
		clickOnLoginButtonEnterToHomePage.click();
		return new homePage();
	}

}

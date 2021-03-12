package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.qa.basePage.testBase;

public class cartPage extends testBase {

	@FindBy(xpath = "//select[@id='billing-address-select']")
	WebElement clickOnBillingAddress;
	
	

	@FindBy(xpath = "//*[@id='billing-address-select']/option[9]")
	WebElement selectTheBillingAddress;

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	WebElement clickOnContinueBillingButton;

	// select[@id='shipping-address-select']

	@FindBy(xpath = "//select[@id='shipping-address-select']")
	WebElement clickOnShippingAddress;
	// *[@id="billing-address-select"]/option[9]

	@FindBy(xpath = "//*[@id='shipping-address-select']/option[9]")
	WebElement sellectTheShippingAddress;

	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	WebElement clickOnContinueShippingButton;

	@FindBy(xpath = "//input[@id='shippingoption_1']")
	WebElement clickOnShippingMethodNextDayair;

	@FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
	WebElement clickOnContinueShippingNextDayAirButton;

	@FindBy(xpath = "//input[@id='paymentmethod_0']")
	WebElement clickOnCashOnDelivery;

	@FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
	WebElement clickOnContinueButtonPayment;

	@FindBy(xpath = "//p[text()='You will pay by COD']")
	WebElement validateTheText;

	// you need to scroll up
	// input[@class='button-1 payment-method-next-step-button']
	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement clickOnConfirmButton;

	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	WebElement validatTheTextOrderIsSuccess;

	
	@FindBy(xpath = "//*[@onclick='PaymentInfo.save()']")
	WebElement clickOnPaymentContinue;
	
	
	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement clickOnContinueButton;

	@FindBy(xpath = "//ul[@class='details']/li")
	WebElement printTheOrderNumber;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement clickContinueButton;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement clickOnLogOutButton;

	public cartPage() {
		PageFactory.initElements(driver, this);

	}

	public void enterNewBillingAddressFilling() {
		Select select=new Select(clickOnBillingAddress);
		select.selectByVisibleText("Akansha Anuranjani, Gachibowli, Hyderabad 500032, India");
		clickOnContinueBillingButton.click();
		
	
	}

	public void selectTheShippingAddressAsSameAsBillingAddress() {
		Select select=new Select(clickOnShippingAddress);
		select.selectByVisibleText("Akansha Anuranjani, Gachibowli, Hyderabad 500032, India");
		//sellectTheShippingAddress.click();
		
		clickOnContinueShippingButton.click();
	}

	public void selectTheShippingAddressAsNextDayAir() {
		clickOnShippingMethodNextDayair.click();
		clickOnContinueShippingNextDayAirButton.click();
	}

	public void selectThePaymentMethodAsCashOnDelivery() {
		clickOnCashOnDelivery.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		clickOnContinueButtonPayment.click();
	}

	public void validateOrderText() {
		
		String actual=validateTheText.getText();
		String Expected="You will pay by COD";
		Assert.assertEquals(Expected, actual);
		
		clickOnPaymentContinue.click();
	}

	public void confirmOrder() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		clickOnContinueButton.click();
	}

	public void valiadateTheTextOfOrderSuccess() {
		String actual=validatTheTextOrderIsSuccess.getText();
		String Expected="Your order has been successfully processed!";
		Assert.assertEquals(Expected, actual);
	}
	//Your order has been successfully processed!
	public void printTheOrderNumberAndLogout() {
		System.out.println(printTheOrderNumber.getText());
		clickContinueButton.click();
		clickOnLogOutButton.click();
	}
}

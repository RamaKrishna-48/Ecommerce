package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.basePage.testBase;

public class booksPage extends testBase { 

	@FindBy(xpath = "//div[@class='count']")
	WebElement checkTheStatus;

	

	// The product has been added to shopping cart
	@FindBy(xpath = "//span[@class='price-value-13']")
	WebElement getTheTextOfPrice;

	@FindBy(xpath = "//input[@id='addtocart_13_EnteredQuantity']")
	WebElement enterTheQuentity;
	//input[@id='add-to-cart-button-13']
	@FindBy(xpath = "//input[@id='add-to-cart-button-13']")
	WebElement clickOnAddToCartButton;

	// The product has been added to shopping cart validate the message
	@FindBy(xpath = "//p[@class='content']")
	WebElement validateTheMessage;
	// click on shopingcart
	@FindBy(xpath = "//a[text()='shopping cart']")
	WebElement clickOnShopingCart;

	@FindBy(xpath = "//*[@class='cart-footer']/div[2]/div/table/tbody/tr[1]/td[2]/span")
	WebElement validateTheSubTotalPrice;

	@FindBy(xpath = "//input[@id='termsofservice']")
	WebElement clickOnTermsAndServices;

	@FindBy(xpath = "//*[@id='checkout']")
	WebElement clickOnCheckoutButton;

	public booksPage() {
		PageFactory.initElements(driver, this);

	}

	public void GetThePriceValueAndEnterQuentityClickOnAddToCartButton() {
		
		System.out.println("Price Details  :" + getTheTextOfPrice.getText());
		enterTheQuentity.clear();
		enterTheQuentity.sendKeys("2");
		clickOnAddToCartButton.click();
	}

	public void validateTextMessage() {

		String actual = validateTheMessage.getText();
		String Expected = "The product has been added to your shopping cart";
		Assert.assertEquals(Expected, actual);
		clickOnShopingCart.click();
	}

	public void validateTheSubTotalPrice() {
		String actual = validateTheSubTotalPrice.getText();
		String Expected = "20.00";
		Assert.assertEquals(Expected, actual);
		System.out.println("Sub Total Price actualPrice :" + actual + "Sub Total Price expectedPrice   :" + Expected);
	}

	public cartPage clickOnTermsAndServicesAndCheckOutButtons() {
		clickOnTermsAndServices.click();
		clickOnCheckoutButton.click();
		return new cartPage();
	}

}

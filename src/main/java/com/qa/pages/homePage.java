package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.basePage.testBase;

public class homePage extends testBase {
	@FindBy(xpath = "//div[@class='product-item']//img[@title='Show details for Computing and Internet']")
	WebElement clickOnBookItem;

	@FindBy(xpath = "//a[text()='atest@gmail.com']")
	WebElement validateTheEmailID;

	@FindBy(xpath = "//div[@class='count']")
	WebElement itemsIsNotAvailabale;

	@FindBy(xpath = "//span[@class='cart-qty']")
	WebElement moveToShopingCartAndPerformTheaction;

	@FindBy(xpath = "//input[@type='button']")
	WebElement clickOnGoToCart;

	@FindBy(xpath = "//input[@name='removefromcart']")
	WebElement clickOnRemoveButton;

	@FindBy(xpath = "//input[@name='updatecart']")
	WebElement clickOnUpdateButton;

	@FindBy(xpath = "//*[@class='top-menu']/li[1]")
	WebElement clickOnBooks;
	@FindBy(xpath = "//*[@id='add-to-cart-button-13']")
	WebElement clickOnAddToCartButton;
	
	

	public homePage() {
		PageFactory.initElements(driver, this);

	}

	public void validateTheUserAcountID() {
		String actual=validateTheEmailID.getText();
		String Expected="atest@gmail.com";
		Assert.assertEquals(Expected, actual);

	}

	public void performTheActionShoppingCartAndClickTheGoToCartButton() {
		Actions action = new Actions(driver);
		action.moveToElement(moveToShopingCartAndPerformTheaction).build().perform();
		clickOnGoToCart.click();
	}

	public void clearTheShopingCart() {
		clickOnRemoveButton.click();
		clickOnUpdateButton.click();
		
	}

	public void selectTheItemAndAddToCart() {
		clickOnBooks.click();
		clickOnBookItem.click();
		clickOnAddToCartButton.click();
	}
	
	public booksPage selectTheBooksFromCategoryAndReturnToBooksPage() {
		clickOnBooks.click();
		clickOnBookItem.click();
		return new booksPage();
	}
	

}

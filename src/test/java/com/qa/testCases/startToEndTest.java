package com.qa.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basePage.testBase;
import com.qa.pages.booksPage;
import com.qa.pages.cartPage;
import com.qa.pages.homePage;
import com.qa.pages.loginPage;

public class startToEndTest extends testBase {
	loginPage login;
	homePage homepage;
	booksPage bookPage;
	cartPage cartpage;

	public startToEndTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		linkTest();
		login = new loginPage();
		homepage = new homePage();
		bookPage = new booksPage();
		cartpage = new cartPage();
	}

	@Test(priority = 1)
	public void validateTheWelcomePleaseSignInMessage() {
		test = extent.createTest("Validate “Welcome, Please Sign In!” message");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();

	}

	@Test(priority = 2)
	public void validateTheUserAcountIDOTopRight() {
		test = extent.createTest("Log in with given credentials And Validate The user account ID on top right");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
	}

	

	@Test(priority = 3)
	public void clearTheShopingCartSelectTheBooksFromCategoryAndReturnToBooksPage() {
		test = extent.createTest("Select a book from the list displayed");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
	}

	@Test(priority = 4)
	public void clearTheShopingItems() {
		test = extent.createTest(
				"Select “Books” from Categories and Get the price details and enter the quantity Click On Add to cart Button");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.selectTheItemAndAddToCart();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
	}

	@Test(priority = 5)
	public void validateTextMessage() {
		test = extent.createTest("Validate “The product has been added to shopping cart” message");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();

	}

	@Test(priority = 6)
	public void validateTheSubTotalPrice() {
		test = extent.createTest(
				"Click on “shopping cart” on top right and validate the “Sub-Total” Price for selected book.");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();
		bookPage.validateTheSubTotalPrice();
	}

	@Test(priority = 7)
	public void clickOnTermsAndServicesAndCheckOutButtons() {
		test = extent.createTest("click On Terms And Services And CheckOutButtons");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();
		bookPage.validateTheSubTotalPrice();
		cartpage = bookPage.clickOnTermsAndServicesAndCheckOutButtons();
	}

	@Test(priority = 8)
	public void sellectNewBillingAddressFromDropDownAndFillTheAdrresClickOnContinue() {
		test = extent.createTest("Select “New Address” From “Billing Address” drop down.And Click On Continue Button");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();
		bookPage.validateTheSubTotalPrice();
		cartpage = bookPage.clickOnTermsAndServicesAndCheckOutButtons();
		cartpage.enterNewBillingAddressFilling();
	}

	@Test(priority = 9)
	public void selectTheShippingAddressAsSameAsBillingAddress() {
		test = extent.createTest(
				"Select the “Shipping Address” as same as “Billing Address” from “ShippingAddress” drop down and click on “Continue”.");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();
		bookPage.validateTheSubTotalPrice();
		cartpage = bookPage.clickOnTermsAndServicesAndCheckOutButtons();
		cartpage.enterNewBillingAddressFilling();
		cartpage.selectTheShippingAddressAsNextDayAir();
	}

	@Test(priority = 10)
	public void selectTheShippingAddressAsNextDayAir() {
		test = extent.createTest("Select the shipping method as “Next Day Air” and click on “Continue”");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();
		bookPage.validateTheSubTotalPrice();
		cartpage = bookPage.clickOnTermsAndServicesAndCheckOutButtons();
		cartpage.enterNewBillingAddressFilling();
		cartpage.selectTheShippingAddressAsSameAsBillingAddress();
		cartpage.selectTheShippingAddressAsNextDayAir();

	}

	@Test(priority = 11)
	public void selectThePaymentMethodAsCashOnDelivery() {
		test = extent.createTest("Choose the payment method as COD (Cash on delivery)and click on “Continue”");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();
		bookPage.validateTheSubTotalPrice();
		cartpage = bookPage.clickOnTermsAndServicesAndCheckOutButtons();
		cartpage.enterNewBillingAddressFilling();
		cartpage.selectTheShippingAddressAsSameAsBillingAddress();
		cartpage.selectTheShippingAddressAsNextDayAir();
		cartpage.selectThePaymentMethodAsCashOnDelivery();
	}

	@Test(priority = 12)
	public void validateOrderText() {
		test = extent.createTest("Validate the message “You will pay by COD” and click on “Continue”");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();
		bookPage.validateTheSubTotalPrice();
		cartpage = bookPage.clickOnTermsAndServicesAndCheckOutButtons();
		cartpage.enterNewBillingAddressFilling();
		cartpage.selectTheShippingAddressAsSameAsBillingAddress();
		cartpage.selectTheShippingAddressAsNextDayAir();
		cartpage.selectThePaymentMethodAsCashOnDelivery();
		cartpage.validateOrderText();

	}

	
	@Test(priority = 13)
	public void valiadateTheTextOfOrderSuccessAndLagoutTheAppliaction() {
		test = extent.createTest(
				"Validate the message “Your order has been successfully processed!” and print the Order number and Continue Finally Logout From The Application");
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.validateTheUserAcountID();
		homepage.selectTheItemAndAddToCart();
		homepage.performTheActionShoppingCartAndClickTheGoToCartButton();
		homepage.clearTheShopingCart();
		bookPage = homepage.selectTheBooksFromCategoryAndReturnToBooksPage();
		bookPage.GetThePriceValueAndEnterQuentityClickOnAddToCartButton();
		bookPage.validateTextMessage();
		bookPage.validateTheSubTotalPrice();
		cartpage = bookPage.clickOnTermsAndServicesAndCheckOutButtons();
		cartpage.enterNewBillingAddressFilling();
		cartpage.selectTheShippingAddressAsSameAsBillingAddress();
		cartpage.selectTheShippingAddressAsNextDayAir();
		cartpage.selectThePaymentMethodAsCashOnDelivery();
		cartpage.validateOrderText();
		cartpage.confirmOrder();
		cartpage.valiadateTheTextOfOrderSuccess();
		cartpage.printTheOrderNumberAndLogout();
	}

}

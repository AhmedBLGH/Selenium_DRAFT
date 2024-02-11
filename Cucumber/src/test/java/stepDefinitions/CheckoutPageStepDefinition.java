package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.hc.client5.http.impl.auth.AuthCacheKeeper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	public WebDriver driver;
	public String LandingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public PageObjectManager pageObjectManager;
	public CheckoutPage checkoutPage;

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String name) throws InterruptedException {
	    checkoutPage.CheckoutItems();
	    Thread.sleep(2000);
	}
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
	    
	    Assert.assertTrue(checkoutPage.verifyPromoBtn());
	    Assert.assertTrue(checkoutPage.verifyPromoBtn());
	}
}

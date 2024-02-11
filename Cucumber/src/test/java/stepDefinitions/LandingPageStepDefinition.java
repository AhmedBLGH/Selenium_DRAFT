package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	public WebDriver driver;
	String LandingPageProductName;
	String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPageObjects;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		 this.landingPageObjects = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {

		Assert.assertEquals(landingPageObjects.getTitleLandingPage(), "GreenKart - veg and fruits kart");   
	}

	@When("User searched with ShortName {} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		
		//LandingPageObjects landingPageObjects = new LandingPageObjects(testContextSetup.driver);
		landingPageObjects.searchItem(shortName);
		// la fonction .searchItem() en haut remplace ce code :
		// testContextSetup.driver.findElement(By.className("search-keyword")).sendKeys(shortName);

		Thread.sleep(2000);

		testContextSetup.landingPageProductName = landingPageObjects.getProductName();

	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quatity) {
	 landingPageObjects.incrementQuatity(Integer.parseInt(quatity));
	 landingPageObjects.addToCart();
	}

}

package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class OfferPageStepDef {

	TestContextSetup testContextSetup;
	boolean verify = false;
	String offerPageProductName;

	public OfferPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	public void switchToOffersPage() {
		
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("url de la page")) 
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> browserWindows = testContextSetup.driver.getWindowHandles();
		Iterator<String> i = browserWindows.iterator();
		String parentWindow = i.next();
		String childWindow = i.next();
		testContextSetup.driver.switchTo().window(childWindow);
	}

	@Then("User search for {string} in offers page to check if product exist")
	public void user_search_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) {

		switchToOffersPage();

		WebElement searchBar = testContextSetup.driver.findElement(By.id("search-field"));
		searchBar.click();
		searchBar.sendKeys(shortName);

		offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(offerPageProductName);
	}

	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		assert testContextSetup.LandingPageProductName.contains(offerPageProductName);

	}
}

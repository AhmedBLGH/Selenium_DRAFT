package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class OfferPageStepDef {
	
	TestContextSetup TestContextSetup;
	
	public OfferPageStepDef(TestContextSetup TestContextSetup) {
		this.TestContextSetup = TestContextSetup;
	}
	
	@Then("User search for {string} in offers page to check if product exist")
	public void user_search_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) {

		TestContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> browserWindows = TestContextSetup.driver.getWindowHandles();
		Iterator<String> i = browserWindows.iterator();
		String parentWindow = i.next();
		String childWindow = i.next();
		TestContextSetup.driver.switchTo().window(childWindow);

		WebElement searchBar = TestContextSetup.driver.findElement(By.id("search-field"));
		searchBar.click();
		searchBar.sendKeys(shortName);

		String offerPageProductName = TestContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(offerPageProductName);
	}

	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		
	}
}

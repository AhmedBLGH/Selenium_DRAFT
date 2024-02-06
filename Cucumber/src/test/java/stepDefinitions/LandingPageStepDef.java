package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPageStepDef {

	public WebDriver driver;
	String LandingPageProductName;
	String offerPageProductName;
	
	public LandingPageStepDef(TestContextSetup testContextSetup) {
		
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {

		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}

	@When("User searched with ShortName {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		WebElement searchBar = driver.findElement(By.className("search-keyword"));
		searchBar.click();
		searchBar.sendKeys(shortName);

		Thread.sleep(2000);

		LandingPageProductName = driver.findElement(By.tagName("h4")).getText();
		

	}

	@Then("User search for {string} in offers page to check if product exist")
	public void user_search_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) {

		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> browserWindows = driver.getWindowHandles();
		Iterator<String> i = browserWindows.iterator();
		String parentWindow = i.next();
		String childWindow = i.next();
		driver.switchTo().window(childWindow);

		WebElement searchBar = driver.findElement(By.id("search-field"));
		searchBar.click();
		searchBar.sendKeys(shortName);
		
		offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		System.out.println(offerPageProductName);
	}
	
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    
	}

}

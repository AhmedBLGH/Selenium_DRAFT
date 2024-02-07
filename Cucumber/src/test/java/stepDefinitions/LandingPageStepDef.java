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
import utils.TestContextSetup;

public class LandingPageStepDef {

	public WebDriver driver;
	String LandingPageProductName;
	String offerPageProductName;
	TestContextSetup testContextSetup;
	
	public LandingPageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {

		testContextSetup.driver = new ChromeDriver();

		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

	}

	@When("User searched with ShortName {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {

		WebElement searchBar = testContextSetup.driver.findElement(By.className("search-keyword"));
		searchBar.click();
		searchBar.sendKeys(shortName);

		Thread.sleep(2000);

		testContextSetup.LandingPageProductName = testContextSetup.driver.findElement(By.tagName("h4")).getText();
		

	}

	

}

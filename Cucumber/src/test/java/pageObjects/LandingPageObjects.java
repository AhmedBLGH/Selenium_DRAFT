package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageObjects {

	public WebDriver driver;

	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	private By searchBar = By.className("search-keyword");
	private By productName = (By.tagName("h4"));
	private By TopDealsButton = By.linkText("Top Deals");

	public void searchItem(String shortName) {
		driver.findElement(searchBar).sendKeys(shortName);
	}

	public String getProductName() {

		return driver.findElement(productName).getText();
	}
	
	public void switchToOffersPage() {
		driver.findElement(TopDealsButton).click();
	}
}

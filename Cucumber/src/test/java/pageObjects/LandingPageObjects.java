package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageObjects {

	public WebDriver driver;

	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By searchBar = By.className("search-keyword");
	By productName = (By.tagName("h4"));

	public void searchItem(String shortName) {
		driver.findElement(searchBar).sendKeys(shortName);
	}

	public String getProductName() {

		return driver.findElement(productName).getText();
	}
}

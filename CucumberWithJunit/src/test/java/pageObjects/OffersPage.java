package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	public WebDriver driver;
	private By searchBar = By.id("search-field");
	private By productName = By.cssSelector("tr td:nth-child(1)");

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String shortName) {
		driver.findElement(searchBar).sendKeys(shortName);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}

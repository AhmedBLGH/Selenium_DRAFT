package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPageObjects {
	
	WebDriver driver;
	
	public OffersPageObjects(WebDriver driver){
		this.driver=driver;
	}
	
	private By searchBar = By.id("search-field");
	
	public void searchItem(String shortName) {
		driver.findElement(searchBar).sendKeys(shortName);
	}
	
}

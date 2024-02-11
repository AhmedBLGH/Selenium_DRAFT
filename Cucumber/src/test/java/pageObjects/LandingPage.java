package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By searchBar = By.className("search-keyword");
	private By productName = (By.tagName("h4"));
	private By TopDealsButton = By.linkText("Top Deals");
	private By increment = By.cssSelector("a.increment");
	private By addToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	

	public void searchItem(String shortName) {
		driver.findElement(searchBar).sendKeys(shortName);
	}

	public String getProductName() {

		return driver.findElement(productName).getText();
	}
	
	public void switchToTopDealPage() {
		driver.findElement(TopDealsButton).click();
	}
	
	public String getTitleLandingPage() {
		return driver.getTitle();
	}
	
	public void incrementQuatity(int quatity) {
		int i = quatity-1;
		while(i>0) {
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}

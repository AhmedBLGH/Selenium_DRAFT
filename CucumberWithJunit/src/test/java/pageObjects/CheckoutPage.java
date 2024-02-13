package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	private By cartBag = By.cssSelector("[alt='Cart']");
	private By checkoutButton = (By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"));
	private By promoBtn = By.cssSelector(".promoBtn");
	private By placeOrder = (By.xpath("//button[contains(text(),'Place Order')]"));

	public void CheckoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPlanOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
}

package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test(groups = "a")
public class VerifyTitleTest {

	
	
	@Test
	public void titleTest() {

		SoftAssert soft = new SoftAssert();

		String expectedTitle = "Electronics, ccCars, Fashion, Collectibles, Coupons and More | eBay";
		String expectedText = "Searchcc";

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ebay.com");

		String actualTitle = driver.getTitle();
		String actualText = driver.findElement(By.id("gh-btn")).getAttribute("value");

		soft.assertEquals(actualTitle, expectedTitle);
		soft.assertEquals(actualText, expectedText, "text verification failed");

		soft.assertAll();
	}
}

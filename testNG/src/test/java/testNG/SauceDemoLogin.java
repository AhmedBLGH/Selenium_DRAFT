package testNG;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoLogin {

	private WebDriver driver;

	@BeforeMethod
	public void loginPage() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.saucedemo.com/");

	}

	public void performLogin(String username, String password) {

		WebElement UsernameLog = driver.findElement(By.id("user-name"));
		WebElement passwordlog = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.id("login-button"));

		UsernameLog.sendKeys(username);
		passwordlog.sendKeys(password);
		submitButton.click();

	}

	private void performLogout() {
		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
		menuButton.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

		logoutButton.click();
	}

	private void checkLogo() {
		WebElement logo = driver.findElement(By.className("app_logo"));
		String logotext = logo.getText();
		assertEquals(logotext, "Swag Labs");
	}

	private void checkPanier() {
		WebElement panier = driver.findElement(By.className("shopping_cart_link"));
		String panierChilds = panier.getAttribute("childElementCount");
		assertEquals(panierChilds, "0");
	}

	private void checkGategory() {
		WebElement headerTitle = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String txt = headerTitle.getText();
		assertEquals(txt, "Products");
	}

	private void checkMenu() {
		WebElement menuButton = driver.findElement(By.className("bm-burger-button"));
		WebElement img = menuButton.findElement(By.tagName("img"));
		String classImg = img.getAttribute("class");
		assertEquals(classImg, "bm-icon");
	}

	private void checkSortCombo() {

		WebElement sortContainer = driver.findElement(By.className("select_container"));
		WebElement sortActive = sortContainer.findElement(By.className("active_option"));
		WebElement sortButton = driver.findElement(By.className("product_sort_container"));
		List<WebElement> options = sortButton.findElements(By.tagName("option"));

		assertEquals(sortActive.getText(), "Name (A to Z)");
		assertEquals(options.get(0).getText(), "Name (A to Z)");
		assertEquals(options.get(1).getText(), "Name (Z to A)");
		assertEquals(options.get(2).getText(), "Price (low to high)");
		assertEquals(options.get(3).getText(), "Price (high to low)");

	}

	private void checkProducts() {

		List<WebElement> sortContainer = driver.findElements(By.className("inventory_item"));

		for (int i = 0; i < sortContainer.size(); i++) {
			String altImg = sortContainer.get(i).findElement(By.tagName("img")).getAttribute("alt");
			String itemName = sortContainer.get(i).findElement(By.className("inventory_item_name")).getText();

			assertEquals(altImg, itemName);
		}

	}

	@Test
	public void standardUserLogin() {

		performLogin("standard_user", "secret_sauce");
		checkLogo();
		checkPanier();
		checkMenu();
		checkGategory();
		checkSortCombo();
		checkProducts();
		performLogout();

	}

	@Test
	public void problemUserLogin() {

		performLogin("problem_user", "secret_sauce");
		checkLogo();
		checkPanier();
		checkMenu();
		checkGategory();
		checkSortCombo();
		checkProducts();
		performLogout();

	}
	
	

}

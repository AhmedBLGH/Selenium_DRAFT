package Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Projet3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://nxdh-visage-qa:8080/www/datahub/#/login?redirect=/");
		
		WebDriverWait logWait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement logInButton = logWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn-open")));
		logInButton.click();
		
		WebElement username = driver.findElement(By.className("email"));
		username.sendKeys("belghith.ahmed");
		username.sendKeys(Keys.ENTER);
		
		
		WebDriverWait widgetWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> widgets = widgetWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("title")));
		
		
		
		
		
		
	}

}

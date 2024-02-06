package Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Projet5 {

	public static void main(String[] args) throws InterruptedException {
        
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://facebook.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login")));

	
		
		
		//touver l'élément avec un autre élément en utilisant sa position
		WebElement mdpArea = driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginBtn));
		
		mdpArea.sendKeys("AAAA");
		
		
		
	}

}

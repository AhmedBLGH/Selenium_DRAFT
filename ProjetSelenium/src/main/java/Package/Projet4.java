package Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Projet4 {

	public static void main(String[] args) throws InterruptedException {
        
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://youtube.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search_query")));

	
		
		//search.click();
		
		search.sendKeys("Qualité Logiciel");
		
		//search.sendKeys(Keys.ENTER);
		//search.submit();

		WebElement button = driver.findElement(By.id("search-icon-legacy"));
		button.click();
		
	}

}

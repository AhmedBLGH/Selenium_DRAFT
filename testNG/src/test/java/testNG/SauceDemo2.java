package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo2 {

	@Test
	public void login() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		driver.get("https://www.saucedemo.com/");

		List<WebElement> usernames = driver.findElements(By.tagName("br"));

		WebElement UsernameLog = driver.findElement(By.id("user-name"));
		WebElement passwordlog = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.id("login-button"));

		// Sélectionnez l'élément qui contient le texte avec les balises <br>
        WebElement element = driver.findElement(By.xpath("//*[@id=\"login_credentials\"]"));

        // Obtenez le texte brut de l'élément
        String rawText = element.getText();

        // Divisez le texte en fonction des retours à la ligne (<br>)
        String[] usernamess = rawText.split("\\n");

        // Affichez les usernames extraits
        for (String username : usernamess) {
            System.out.println(username.trim()); 
        }

	}

}

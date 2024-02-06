package Package;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Projet1 {


	public static void main(String[] args) throws InterruptedException {
	
		//System.setProperty("webdriver.chrome.driver", "/driver/chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("http://www.wikipedia.org/");
		
		//attendre la disponibilité d'un element par css selector
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cookie-consent > div.cookie-consent__basic.cookie-consent__inner > div > div > span.btn.width-100.btn--primary.cookie-consent__btn.cookie-basic-consent__btn")));
		
		//stopper l'exec pour 10 secondes
		//Thread.sleep(10);
		
		//trouver et cliquer sur l'element
		driver.findElement(By.cssSelector("span.btn.width-100.btn--primary.cookie-consent__btn.cookie-basic-consent__btn")).click();
		
		//cliquer sur lement 
		//element.click();
		
		
		List<WebElement> lista = driver.findElements(By.className("cta"));
		WebElement hoverElement = driver.findElement(By.className("header__menu-switcher"));
		
		//hover over an element
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverElement).perform();
		
		//récupérer le titre de la page
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		//parcourir tous les élément de la liste et cliquer sur l'élément telecharger;
		for (int i=0; i<lista.size() ;i++)
		{
			
			WebElement button = lista.get(i);
			String text = button.getText();
			System.out.println(text);
			if (text.equals("Télécharger Opera"))
			{
				button.click();
			}

		}
		
		
		
		
	}
	
}

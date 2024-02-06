package Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Form {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://qualitelogiciel.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement v = driver.findElement(By.cssSelector("#root > div.page-root > div:nth-child(1) > div.section-content > div > div.grid-row-root.grid-row-has-columns.grid-row-full-width.grid-row-dd6bcb51-e321-4cbf-9107-20f27f503d29 > div > div > div > ul > li:nth-child(8) > a"));
		v.click();
//		List<WebElement> navItems = driver.findElements(By.tagName("a"));
//		
//		for(int i=0 ; i<navItems.size() ; i++) {
//			WebElement navItem = navItems.get(i);
//			String itemTxt = navItem.getAttribute("innerText");
//			if(itemTxt.equals("Contactez-nous")) {
//				navItem.click();
//			}
//		}
		
		
		WebElement pageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("H2")));
		
		if(pageTitle.getText().equals("Contactez-nous")) {
			List<WebElement> combos = driver.findElements(By.className("form-input-combo"));
			for(int j=0 ; j<combos.size() ; j++) {
				WebElement combo = combos.get(j);
				WebElement label = combo.findElement(By.tagName("label"));
				WebElement txtArea = combo.findElement(By.tagName("input"));
				
				
				
				String labelTxt = label.getText();
				
				if(labelTxt.equals("Nom*")) txtArea.sendKeys("Ahmed Belghith");
				if(labelTxt.equals("E-Mail*")) txtArea.sendKeys("ahmed.ahmedbelghith@gmail.com");
				if(labelTxt.equals("Objet*")) txtArea.sendKeys("testing");
				
					WebElement text = combo.findElement(By.tagName("textarea"));
					text.sendKeys("meeeessssaaageee");
				
							
			}
			
			WebElement submit = driver.findElement(By.cssSelector("[type=submit]"));
			submit.click();
			
			
		}
		
		
		
	}

}

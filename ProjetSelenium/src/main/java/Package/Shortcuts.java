package Package;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shortcuts {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.example.com");
		
		Actions actionProvider = new Actions(driver);
		
		Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		
		keydown.perform();
		
		
}
}

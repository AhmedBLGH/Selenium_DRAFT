package Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxe {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		
		
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
		
		for (int i=0 ; i<checkboxes.size();i++) {
			WebElement checkbox = checkboxes.get(i);
			if (checkbox.isSelected()) checkbox.click();
			System.out.println(checkbox.isSelected());
		}
	}
}

package Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert2 {
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		List<WebElement> btnList = driver.findElements(By.tagName("button"));
		
		for(int i=0 ; i< btnList.size() ;i++) {
			WebElement button = btnList.get(i);
			String buttonText = button.getText();
			if (buttonText.equals("Click for JS Confirm") ) 
			{
			button.click();
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println(alertText);
			alert.dismiss();
			}
			
		}
		
	}
}
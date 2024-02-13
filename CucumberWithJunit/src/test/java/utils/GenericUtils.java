package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}

	public void switchWindowToChild() throws InterruptedException {
		Set<String> browserWindows = driver.getWindowHandles();
		Iterator<String> i = browserWindows.iterator();
		String parentWindow = i.next();
		String childWindow = i.next();
		Thread.sleep(2000);
		driver.switchTo().window(childWindow);
	}
}

package utils;

import java.io.FileInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;   
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		
		String url = prop.getProperty("QAurl");
		String browser_properties = prop.getProperty("browser");
		String browser_mvn = System.getProperty("browser");
		
		//result = testcondition ? value1 : value2
		
		String browser = browser_mvn!=null ? browser_mvn : browser_properties;
		
		if(driver == null) {
			if("chrome".equals(browser)) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.get(url);
			}
			if("firefox".equals(browser)) {
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(url);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			
		}
		
		return driver;
	}

}

package Package;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Projet2 {
	
	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("http://www.opera.com/");
		
	
		driver.navigate().to("https://www.amazon.com/");
		
		//maximiser l'affichage de la fenetre 
		driver.manage().window().maximize();
		
		//minimiser l'affichage de la fenetre 
		driver.manage().window().minimize();
		
		//afficher en full screen
		driver.manage().window().fullscreen();
		
		Dimension size = driver.manage().window().getSize();
		driver.manage().window().setSize(new Dimension(1200,900));
		
		File srcFile = (File) (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
		FileUtils.copyFile(srcFile, new File("./image1.png"));
		
;
	}

}

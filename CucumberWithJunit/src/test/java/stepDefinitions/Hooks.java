package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup){
		this.testContextSetup=testContextSetup;
	}

	@Before("@NetBanking")
	public void method_for_scenario1() {
		System.out.println("this string will be displayed before executing the background"
				+ "of the feature and specifically for scenario with tag @NetBanking");
	}
	
	@Before("@Mortgage")
	public void method_for_scenario2() {
		System.out.println("this string will be displayed before executing the background"
				+ "of the feature and specifically for scenario with tag @Mortgage");
	}
	
	@After
	public void afterSchenario() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenShot(Scenario scenario) throws WebDriverException, IOException {
		
		if(scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot)testContextSetup.testBase.WebDriverManager()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "screenshot");
			}
	}
}

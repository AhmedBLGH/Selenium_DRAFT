package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features="src/test/java/features", 
glue="stepDefinitions", 
monochrome=true,
plugin = {"pretty", 
		"html:target/cucumber.html", 
		"json:target/cucumber.json", 
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"}, 
tags = "@Checkout or @Exercice1")
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}

//@CucumberOptions(features="src/test/java/features", glue="stepDefinitions", monochrome=true, tags = "@SmokeTest or @RegressionTest")
//public class TestNGRunner extends AbstractTestNGCucumberTests {
//	
//}

//@CucumberOptions(features="src/test/java/features", glue="stepDefinitions", monochrome=true, tags = "@SmokeTest and @RegressionTest")
//public class TestNGRunner extends AbstractTestNGCucumberTests {
//	
//}

//@CucumberOptions(features="src/test/java/features", glue="stepDefinitions", monochrome=true, tags = "not @RegressionTest")
//public class TestNGRunner extends AbstractTestNGCucumberTests {
//	
//}



package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features", glue="stepDefinitions", monochrome=true, plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}, tags = "@Exercice")
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
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



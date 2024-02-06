package testNG;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("test case is starting");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test échoué : " + result.getName());

	}
}


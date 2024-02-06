package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest {

	@Test(dataProvider = "dataSet", dataProviderClass = DataProviderFile.class)
	public void test(String username, String password) {
		System.out.println(username + "-----" + password);
	}

	@Test(dataProvider = "dataSet1", dataProviderClass = DataProviderFile.class)
	public void test1(String username, String password, String test) {
		System.out.println(username + "-----" + password + "-----" + test);
	}

}

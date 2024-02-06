package testNG;

import org.testng.annotations.DataProvider;

public class DataProviderFile {
	@DataProvider
	public Object[][] dataSet1() {
		return new Object[][] { { "username", "password", "test" } };
	}

	@DataProvider
	public Object[][] dataSet() {
		Object[][] dataset = new Object[4][2];

		// first data from first row
		dataset[0][0] = "user1";
		dataset[0][1] = "pass1";

		// second data from second row
		dataset[1][0] = "user2";
		dataset[1][1] = "pass2";

		// third data from third row
		dataset[2][0] = "user3";
		dataset[2][1] = "pss3";

		// fourth data from fourth row
		dataset[3][0] = "user4";
		dataset[3][1] = "pss4";

		return dataset;
	}
}

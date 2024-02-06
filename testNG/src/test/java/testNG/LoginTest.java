package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = "a")
public class LoginTest {

	@Test(priority = 2, description = "this tests the login", groups = "reg")
	public void logintest() {
		System.out.println("login successful");
	}

	@Test(priority = 1, description = "this tests the logout")
	public void logouttest() {
		System.out.println("logout successful");
	}

	@Test(priority = 3, groups = "bvt")
	public void ahmed() {
		System.out.println("ahmed successful");
	}

	@Test(priority = 4, groups = { "reg", "bvt" })
	public void ahmed2() {
		System.out.println("ahmed2 successful");
	}

	@BeforeTest
	public void goToApp() {
		System.out.println("going to application");
	}

	@AfterTest
	public void closeApp() {
		System.out.println("closing application");
	}

	@BeforeMethod
	public void test1() {
		System.out.println("before method");
	}

	@AfterMethod
	public void test2() {
		System.out.println("after method");
	}
}

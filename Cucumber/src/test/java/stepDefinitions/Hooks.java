package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

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
}

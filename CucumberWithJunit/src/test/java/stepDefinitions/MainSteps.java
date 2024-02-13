package stepDefinitions;

import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {

	
	@Given("User in on NetBanking landing page")
	public void user_in_on_net_banking_landing_page() {
	    System.out.println("User in on NetBanking landing page");
	}
	@When("^User login into application with (.+) and (.+)$")
	public void user_login_into_application(String username,String password) {
		System.out.println(username+"And"+password);
	}
	@Then("Home page is displayed")
	public void home_page_is_displayed() {
		System.out.println("Home page is displayed");
		
	}
	@Then("Cards are displayed")
	public void cards_are_displayed() {
		System.out.println("Cards are displayed");
	}
	
	@When("User fill in application fields")
	public void user_fill_in_application_fields(List<String> data) {
	   
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
	} 
	
	@Given("User in on Mortgage landing page")
	public void user_in_on_mortgage_landing_page() {
		System.out.println("User in on Mortgage landing page");
	}
}

package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

public String offerPageProductName;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;
//Single responsibilty Principle
//loosly coupled
//Factory Design Pattern
public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}

@Then("^User searched for (.+) shortname in offers page$")
public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
    //offer pafe->enter_>grab text

	switchToOffersPage();
	OffersPage offersPage  =testContextSetup.pageObjectManager.getOffersPage();
	offersPage.searchItem(shortName);
	Thread.sleep(2000);
	 offerPageProductName = offersPage.getProductName();
	
}

public void switchToOffersPage() throws InterruptedException
{
	//if switched to offer page-> skip below part
	LandingPage landingPage  =testContextSetup.pageObjectManager.getLandingPage();
	landingPage.switchToTopDealPage();
	testContextSetup.genericUtils.switchWindowToChild();
	//explicit wait, parse string
	
	
}
@Then("validate product name in offers page matches with Landing page")
public void validate_product_name_in_Offers_page()
{
	assert testContextSetup.landingPageProductName.contains(offerPageProductName);
}

	
}

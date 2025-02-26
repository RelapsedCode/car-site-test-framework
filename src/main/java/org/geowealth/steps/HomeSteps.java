package org.geowealth.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.geowealth.TestContext;
import org.geowealth.pages.HomePage;

public class HomeSteps {

	private TestContext testContext;
	private HomePage homePage;

	public HomeSteps(TestContext testContext) {
		this.testContext = testContext;
		homePage = new HomePage(this.testContext);
	}

	@Given("I load {string} page")
	public void iNavigateToPage(String page) {
		switch (page) {
			case "Home":
				testContext.getDriver().get("https://www.mobile.bg/");
				break;
			default:
				throw new RuntimeException("No page specified.");
		}

	}

	@Then("I click on {string}")
	public void iClickOn(String arg0) {
		homePage.clickOn(arg0);
	}
}

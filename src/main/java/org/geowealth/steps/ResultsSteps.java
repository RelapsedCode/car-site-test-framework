package org.geowealth.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.geowealth.TestContext;
import org.geowealth.pages.HomePage;
import org.geowealth.pages.ResultsPage;

public class ResultsSteps {

    private TestContext testContext;
    private ResultsPage resultsPage;

    public ResultsSteps(TestContext testContext) {
        this.testContext = testContext;
        resultsPage = new ResultsPage(this.testContext);
    }

    @Then("The results are counted and posted")
    public void countAndPostTheResults() {
        resultsPage.countResults();
    }

}

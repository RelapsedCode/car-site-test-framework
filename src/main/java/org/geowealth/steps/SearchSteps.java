package org.geowealth.steps;

import com.google.common.collect.Table;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.geowealth.TestContext;
import org.geowealth.pages.HomePage;
import org.geowealth.pages.SearchPage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SearchSteps {

    private TestContext testContext;
    private SearchPage searchPage;

    public SearchSteps(TestContext testContext) {
        this.testContext = testContext;
        searchPage = new SearchPage(this.testContext);
    }

    @Then("I fill the following vehicle criteria")
    public void iFillTheFollowingVehicleSearchCriteria(DataTable searchCriteria) {
        List<Map<String, String>> rows = searchCriteria.asMaps(String.class, String.class);

        searchPage.fillCarBrand(rows.get(0).get("brand"))
                .fillCarModel(rows.get(0).get("model"))
                .fillExtras(new ArrayList<>(Arrays.asList(rows.get(0).get("extras").split(","))));
    }

    @Then("I click button {string}")
    public void iClickBtn(String arg) {
        searchPage.clickBtn("Търси");
    }

}


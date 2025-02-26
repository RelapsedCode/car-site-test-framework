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
    private HomePage homePage;

    public SearchSteps(TestContext testContext) {
        this.testContext = testContext;
        homePage = new HomePage(this.testContext);
    }

    @Given("I search for a vehicle with the following criteria")
    public void iNavigateToPage(DataTable searchCriteria) {
        SearchPage searchPage = new SearchPage(testContext);
        List<Map<String, String>> rows = searchCriteria.asMaps(String.class, String.class);

        searchPage.fillCarBrand(rows.get(0).get("brand"))
                  .fillCarModel(rows.get(0).get("model"))
                  .fillExtras(new ArrayList<>(Arrays.asList(rows.get(0).get("extras").split(","))));
    }

}


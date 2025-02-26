package org.geowealth.pages;

import org.geowealth.TestContext;
import org.geowealth.utilities.LocatorBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {
    private LocatorBuilder locatorBuilder = new LocatorBuilder();
    private TestContext testContext;

    @FindBy(xpath = "//*[@id='cookiescript_accept'][1]")
    private WebElement acceptCookies;

    public ResultsPage(TestContext testContext) {
        this.testContext = testContext;
        PageFactory.initElements(this.testContext.getDriver(), this);
    }
}

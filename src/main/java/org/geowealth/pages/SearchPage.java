package org.geowealth.pages;

import org.geowealth.TestContext;
import org.geowealth.utilities.LocatorBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    private TestContext testContext;
    private LocatorBuilder locatorBuilder = new LocatorBuilder();

    @FindBy(xpath = "//*[@id='cookiescript_accept'][1]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//*[@class='cat1'])[1]")
    private WebElement typeOfVehicles;

    @FindBy(xpath = "//*[@class='BG'][1]")
    private WebElement searchLocation;

    @FindBy(xpath = "//input[@name='marka']")
    private WebElement carBrandInput;

    @FindBy(xpath = "//input[@name='model']")
    private WebElement carModelInput;

    private static final String carBrandAndModelElementLocator = "//span[ancestor::*[@class=\"akSearchMarki\"] and text()='%s'][1]";

    public SearchPage(TestContext testContext) {
        this.testContext = testContext;
        PageFactory.initElements(this.testContext.getDriver(), this);
    }

    public SearchPage fillCarBrand(String carBrandStr) {
        testContext.getWait().elementToBeClickable(carBrandInput);
        carBrandInput.click();

        WebElement desiredCarBrand = testContext.getElement(By.xpath
                (locatorBuilder.build(carBrandAndModelElementLocator, carBrandStr)));
        testContext.getWait().elementToBeClickable(desiredCarBrand);
        desiredCarBrand.click();

        return this;
    }

    public SearchPage fillCarModel(String carModel) {
        testContext.getWait().elementToBeClickable(carModelInput);
        carModelInput.click();

        WebElement desiredCarModel = testContext.getElement(By.xpath
                (locatorBuilder.build(carBrandAndModelElementLocator, carModel)));
        testContext.getWait().elementToBeClickable(desiredCarModel);
        desiredCarModel.click();
        return this;
    }

    public SearchPage fillExtras(List<String> extras) {
        for (String extra : extras) {
            String extrasElementLocator = "//span[text()='%s']/parent::label";
            WebElement desiredExtra = testContext.getElement(By.xpath
                    (locatorBuilder.build(extrasElementLocator, extra.trim())));
            assert desiredExtra != null;
            testContext.getWait().elementToBeClickable(desiredExtra);
            desiredExtra.click();
        }
        return this;
    }

}

package org.geowealth.pages;

import org.geowealth.TestContext;
import org.geowealth.utilities.LocatorBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private LocatorBuilder locatorBuilder = new LocatorBuilder();
    private TestContext testContext;

    @FindBy(xpath = "//*[@id='cookiescript_accept'][1]")
    private WebElement acceptCookies;

    @FindBy(xpath = "(//*[@class='cat1'])[1]")
    private WebElement typeOfVehiclesAutos;

    @FindBy(xpath = "(//*[@class='BG'])")
    private WebElement searchLocation;

    @FindBy(xpath = "(//*[text()='Търсене'])")
    private WebElement searchPage;


    public HomePage(TestContext testContext) {
        this.testContext = testContext;
        PageFactory.initElements(this.testContext.getDriver(), this);
    }

    public HomePage clickOn(String term) {
        WebElement el;

        switch (term) {
            case "Търсене":
                el = searchPage;
                break;
            case "Приемане на бисквитките":
                el = acceptCookies;
                break;
            case "Автомобили и Джипове":
                el = typeOfVehiclesAutos;
                break;
            case "Само в България":
                el =  searchLocation;
                break;
            default:
                throw new RuntimeException("No element specified.");
        }
        testContext.getWait().elementToBeVisible(el);
        testContext.getWait().elementToBeClickable(el);
        el.click();
        return this;
    }

}

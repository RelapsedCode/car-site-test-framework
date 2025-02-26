package org.geowealth;

import java.time.Duration;
import java.util.List;

import org.geowealth.utilities.CustomWait;
import org.geowealth.utilities.DriverFactory;
import org.geowealth.utilities.JavascriptActions;
import org.geowealth.utilities.LocatorBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;


public class TestContext {

    private static WebDriver driver = new DriverFactory().getDriver();
    private final WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    private final CustomWait customWait = new CustomWait(this.wait);
    private final LocatorBuilder locatorBuilder = new LocatorBuilder();
    private final Faker faker = new Faker();
    private final JavascriptActions javascriptActions = new JavascriptActions(driver);
    public LocatorBuilder getLocatorBuilder() {
        return locatorBuilder;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public CustomWait getWait() {
        return customWait;
    }

    public WebElement getElement(By elementLocator) {
        return driver.findElement(elementLocator);
    }

    public List<WebElement> getElements(By elementLocator) {
        return driver.findElements(elementLocator);
    }

    public JavascriptActions getJavascriptActions() {
        return javascriptActions;
    }

    public Faker getFaker() {
        return faker;
    }
}

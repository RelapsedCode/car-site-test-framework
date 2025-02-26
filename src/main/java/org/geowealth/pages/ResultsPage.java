package org.geowealth.pages;

import lombok.extern.slf4j.Slf4j;
import org.geowealth.TestContext;
import org.geowealth.utilities.LocatorBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Debug;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class ResultsPage {
    private LocatorBuilder locatorBuilder = new LocatorBuilder();
    private TestContext testContext;

    @FindBy(xpath = "//*[@class='a saveSlink gray'][1]")
    private WebElement lastPage;

    @FindBy(xpath = "//*[@class='saveSlink next'][1]")
    private WebElement nextPage;

    private By vipAd = By.xpath("//*[@class='promoLine' and @src='https://cdn2.focus.bg/mobile/images/picturess/icons/hpages/VIP-wrap.svg']");
    private By topAd = By.xpath("//*[@class='promoLine' and @src='https://cdn2.focus.bg/mobile/images/picturess/icons/hpages/TOP-wrap.svg']");
    private By bestAd = By.xpath("//*[@class='promoLine' and @src='https://cdn2.focus.bg/mobile/images/picturess/icons/hpages/BEST-wrap.svg']");

    public ResultsPage(TestContext testContext) {
        this.testContext = testContext;
        PageFactory.initElements(this.testContext.getDriver(), this);
    }

    public ResultsPage countResults() {
        int vipAdCount = 0;
        int topAdCount = 0;
        int bestAdCount = 0;

        int pagesCount = Integer.parseInt(lastPage.getText());

        do {
            List<WebElement> vipAds = testContext.getElements(vipAd);
            List<WebElement> topAds = testContext.getElements(topAd);
            List<WebElement> bestAds = testContext.getElements(bestAd);

            vipAdCount += vipAds.size();
            topAdCount += topAds.size();
            bestAdCount += bestAds.size();

            if (pagesCount != 1) {
                testContext.getWait().elementToBeClickable(nextPage);
                nextPage.click();
                pagesCount--;
            }
        } while (pagesCount > 1);

        System.out.println("VIP ad count is: " + vipAdCount );
        System.out.println("TOP ad count is: " + topAdCount );
        System.out.println("BEST ad count is: " + bestAdCount );

        log.info("VIP ad count is: {}", vipAdCount );
        log.info("TOP ad count is: {}", topAdCount );
        log.info("BEST ad count is: {}", bestAdCount );

        return this;
    }

}

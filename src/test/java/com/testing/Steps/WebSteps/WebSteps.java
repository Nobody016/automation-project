package com.testing.Steps.WebSteps;

import com.testing.Pages.WebPage;
import lombok.SneakyThrows;
import net.serenitybdd.annotations.Step;

public class WebSteps {
    private WebPage webPage = new WebPage();

    @Step
    public void navigateToUrl(String url) {
        webPage.navigateToUrl(url);
    }

    @Step
    public void waitForTimeInSeconds(String seconds) {
        webPage.wait(seconds);
    }

    @Step
    @SneakyThrows
    public void clickOnWebElement(String locator) {
        webPage.clickOnWebElement(locator);
    }

}

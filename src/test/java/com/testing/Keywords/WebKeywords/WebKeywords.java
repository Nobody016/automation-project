package com.testing.Keywords.WebKeywords;

import com.testing.Steps.WebSteps.WebSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

public class WebKeywords {

    @Steps
    private final WebSteps webSteps = new WebSteps();


    @Given("Navigate to url {string}")
    public void navigateToUrl(String url) {
        webSteps.navigateToUrl(url);
    }

    @And("Wait for {string} seconds")
    public void waitForTimeInSeconds(String seconds) {
        webSteps.waitForTimeInSeconds(seconds);
    }

    @And("Click on web object {string}")
    public void clickOnWebElement(String locator) {
        webSteps.clickOnWebElement(locator);
    }

}

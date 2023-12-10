package com.testing.Pages;

import com.testing.Config.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebPage {

    private static final Logger log = LoggerFactory.getLogger(WebPage.class);
    WebDriverManager webDriverManager = new WebDriverManager();
    WebDriver getDriver = webDriverManager.getDriver();

    public void navigateToUrl(String url) {
        getDriver.navigate().to(url);
        log.info("Successfully navigated to: " + url);
    }

    @SneakyThrows
    public void wait(String sec) {
        int seconds = Integer.parseInt(sec);
        try {
            Thread.sleep(seconds * 1000);
            log.info("Completed wait for " + seconds + " seconds.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Wait was interrupted", e);
        }
    }

    public void clickOnWebElement(String locator) {
        WebElement element = getWebElement(locator);
        element.click();
    }

    public WebElement getWebElement(String locator) {
        WebElement element;
        WebDriver driver = getDriver;

        if (locator.startsWith("//")) {
            element = driver.findElement(By.xpath(locator));
        } else {
            locator = locator.replace("css:", "");
            element = driver.findElement(By.cssSelector(locator));
        }
        // Scroll element in to view using JavaScript.
        JavascriptExecutor je = (JavascriptExecutor) getDriver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);


        return element;
    }


}

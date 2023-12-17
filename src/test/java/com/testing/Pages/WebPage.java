package com.testing.Pages;

import com.testing.Config.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.testing.Config.WebDriverManager.getDriver;


public class WebPage {

    private static final Logger log = LoggerFactory.getLogger(WebPage.class);
    WebDriverManager webDriverManager = new WebDriverManager();
    WebDriver getDriver = getDriver();

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
    public void clickObjectWithJavaScript(String locator) {
        WebElement ele = getWebElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", ele);
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

    public List<WebElement> getIFramesList() {
        return getDriver().findElements(By.xpath("//iframe"));
    }

    public void switchFrame(WebElement webElem) {
        getDriver().switchTo().frame(webElem);
    }

    public void switchBackFromFrame() {
        getDriver().switchTo().defaultContent();
    }

}

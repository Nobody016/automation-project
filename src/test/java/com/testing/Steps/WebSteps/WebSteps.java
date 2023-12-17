package com.testing.Steps.WebSteps;

import com.testing.Pages.WebPage;
import com.testing.Utils.Retry;
import lombok.SneakyThrows;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeEnabledException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WebSteps {
    private WebPage webPage = new WebPage();
    private static final Logger log = LoggerFactory.getLogger(WebPage.class);

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
        Retry.retryOnException(20, 150, "Element not found: " + locator, () -> {
            try {
                webPage.clickOnWebElement(locator);
            } catch (NoSuchElementException | ElementShouldBeEnabledException e) {
                // Retrieves all iframes on the page and iterates through them to locate the element.
                // Throws an error to trigger a retry if no iframe is found or the element isn't located within the iframes.

                List<WebElement> listOfIframes = webPage.getIFramesList();
                int listSize = listOfIframes.size();
                log.debug("Number of iframes: '{}'", listSize);
                if (listSize > 0) {
                    for (int i = 0; i < listSize; i++) {
                        WebElement iFrame = listOfIframes.get(i);
                        try {
                            webPage.switchFrame(iFrame);
                            log.debug("Looping through iframes to find the given element.");
                            webPage.clickOnWebElement(locator);
                            break;
                        } catch (Exception exception) {
                            //switch back from frame if failed in order to be prepared for retrying without being into a frame
                            webPage.switchBackFromFrame();
                            if (i == listSize - 1) {
                                throw new RuntimeException("Element wasn't found inside iFrame or element wasn't intractable!");
                            }
                        }
                    }
                } else {
                    throw new RuntimeException("No iFrames found!");
                }
                // Switch back from the frame to the main content. This ensures readiness for a retry attempt without being trapped inside an iframe.
                webPage.switchBackFromFrame();
            }
        });
        log.debug("Clicked on the element identified with locator: " + locator);
    }

    @SneakyThrows
    @Step
    public void clickObjectWithJavaScript(String locator) {

        Retry.retryOnException(20, 150, "Element not found: " + locator, () -> {
            try {
                webPage.clickObjectWithJavaScript(locator);
            } catch (NoSuchElementException | ElementShouldBeEnabledException e) {
                // Retrieves all iframes on the page and iterates through them to locate the element.
                // Throws an error to trigger a retry if no iframe is found or the element isn't located within the iframes.
                List<WebElement> listOfIframes = webPage.getIFramesList();
                int listSize = listOfIframes.size();
                log.debug("Number of iframes: '{}'", listSize);
                if (listSize > 0) {
                    for (int i = 0; i < listSize; i++) {
                        WebElement iFrame = listOfIframes.get(i);
                        try {
                            webPage.switchFrame(iFrame);
                            webPage.clickObjectWithJavaScript(locator);
                            break;
                        } catch (Exception exception) {
                            //switch back from frame if failed in order to be prepared for retrying without being into a frame
                            webPage.switchBackFromFrame();
                            if (i == listSize - 1) {
                                throw new RuntimeException("Element wasn't found inside iFrame or element wasn't intractable!");
                            }
                        }
                    }
                } else {
                    throw new RuntimeException("No iFrames identified!");
                }
                //switch back from frame if failed in order to be prepared for retrying without being into a frame
                webPage.switchBackFromFrame();
            }
        });
        log.debug("Clicked on the element identified with locator: " + locator);
    }

}

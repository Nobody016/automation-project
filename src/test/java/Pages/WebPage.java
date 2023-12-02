package Pages;

import WebDriver.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
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
}

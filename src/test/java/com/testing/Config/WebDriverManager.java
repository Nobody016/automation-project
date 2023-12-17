package com.testing.Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.testing.Utils.PropertyHelper.getSerenityProperty;

public class WebDriverManager {
    private static WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(WebDriverManager.class);

    public WebDriverManager() {
        // Private constructor to prevent direct instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Stefan\\Documents\\ChromeDriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            // Chrome Options
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            // If getHeadlessStatus() returns true
            if (getHeadlessStatus()) {
                options.addArguments("--headless");
            }


            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                log.error("Error occurred while closing the driver: " + e.getMessage(), e);
            } finally {
                driver = null; // Ensure driver is set to null regardless
            }
        }
    }
    public static void killDriverProcesses() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            log.error("Error occurred while killing the driver processes: " + e.getMessage(), e);
        }
    }

    /**
     * Determines whether the driver is set to run in headless mode based on the 'chrome.switches' property.
     * Returns true if 'chrome.switches' explicitly indicates headless mode, false otherwise.
     */
    public static boolean getHeadlessStatus() {
        String chromeSwitches = getSerenityProperty("chrome.switches");

        if ("--headless".equals(chromeSwitches)) {
            log.info("Driver is set to run in headless mode.");
            return true;
        } else {
            log.info("Driver is set to run in non-headless mode. Current chrome.switches value: " + chromeSwitches);
            return false;
        }
    }

}


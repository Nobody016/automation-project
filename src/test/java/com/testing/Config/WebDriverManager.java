package com.testing.Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;

    public WebDriverManager() {
        // Private constructor to prevent direct instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set up WebDriver only if it hasn't been initialized yet
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Stefan\\Documents\\ChromeDriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            // ... other options ...

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set driver to null after closing
        }
    }
}


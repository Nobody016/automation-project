package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriverManager() {
        // Set up WebDriver in the constructor
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Stefan\\Documents\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        // ... other options ...

        driver = new ChromeDriver(options);
    }

    public  WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}


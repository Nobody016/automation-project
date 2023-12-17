package com.testing.Config;

import com.testing.Pages.WebPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private WebDriverManager webDriverManager = new WebDriverManager();
    private static final Logger log = LoggerFactory.getLogger(WebPage.class);


    @Before(order = 1)
    public void beforeScenario(Scenario scenario) {
        log.info("Scenario: '{}', started.", scenario.getName());
    }


    @After()
    public void tearDown() {
        // Force closing the driver
        WebDriverManager.killDriverProcesses();
    }


}

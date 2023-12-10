package com.testing.Config;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private WebDriverManager webDriverManager = new WebDriverManager();


    @Before(order = 1)
    public void beforeScenario() {
        System.out.println("Before Scenario");
    }

    @After(order = 1)
    public void afterScenario() {
        System.out.println("After Scenario");
        WebDriverManager.closeDriver();
    }


}

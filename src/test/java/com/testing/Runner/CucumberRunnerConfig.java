package com.testing.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "myproject.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)

public class CucumberRunnerConfig {
}

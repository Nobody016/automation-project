package com.testing.Utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class PropertyHelper {

    public static String getBrowserResolution() {
        return getSerenityProperty("browser.resolution");
    }

    private PropertyHelper() {
        throw new IllegalStateException("Utility class");
    }
    public static String getSerenityProperty(String propertyName) {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(variables).getProperty(propertyName);
    }

}

package stepdefinitions;

import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ScenarioHooks {
    @Before
    public void beforeScenario() {
        DriverSingleton.getDriver();
    }

    @After
    public void afterScenario() {
        DriverSingleton.closeDriver();
    }
}
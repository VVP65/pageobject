package tests;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
    public static Logger log = LogManager.getRootLogger();

    SoftAssert softAssertion = new SoftAssert();

    protected WebDriver driver;

    @BeforeMethod()
    public void browserSetUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
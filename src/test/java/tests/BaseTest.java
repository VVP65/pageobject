package tests;

import java.util.logging.Logger;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.TestListener;

@Listeners({TestListener.class})
public class BaseTest {
    protected Logger logger = Logger.getGlobal();

    SoftAssert softAssertion = new SoftAssert();

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
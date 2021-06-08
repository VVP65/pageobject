package test.baseTest;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected Logger logger = Logger.getGlobal();

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("Chrome") String browser) throws Exception {
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.geco.driver", "src\\test\\resources\\webdrivers\\gecodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "src\\test\\resources\\webdrivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
    }

//    @AfterClass(alwaysRun = true)
//    public void browserTearDown() {
//        driver.quit();
//        driver = null;
//    }
}
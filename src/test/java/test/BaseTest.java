package test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageobject.AbstractPage;


public class BaseTest extends AbstractPage {
    public BaseTest(WebDriver driver) {
        super(driver);
    }

    public Logger logger = Logger.getGlobal();

    @BeforeClass(alwaysRun = true)

    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.geco.driver", "src\\main\\resources\\webdrivers\\gecodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\webdrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", "src\\main\\resources\\webdrivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else{
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.googlePages.GoogleHomePage;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest extends BaseTest {

    @Test
    public void seleniumGridWorkingCapacityCheck() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("chrome");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.12:4444/wd/hub"), capabilities);

        String googleHomePageTitle = new GoogleHomePage(driver)
                .openGooglePage()
                .getPageTitle();

        logger.info(String.format("Google Home Page Title: %s", googleHomePageTitle));
        Assert.assertTrue(googleHomePageTitle.contains("Google"), "Current page does not belong to Google Home Page");
    }
}
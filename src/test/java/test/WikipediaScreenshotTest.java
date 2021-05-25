package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.WikipediaHomePage;
import test.BaseTest;

public class WikipediaScreenshotTest extends BaseTest {
    public WikipediaScreenshotTest(WebDriver driver) {
        super(driver);
    }

    @Test
    public void wikipediaScreenshotIsPresentCheck() {
        int screenshotCapturedByAshot = new WikipediaHomePage(driver)
                .openWikipediaHomePage()
                .getImageWidthForScreenshotOfTheFirstDYKSectionElement();
        Assert.assertTrue(screenshotCapturedByAshot > 0, "The image doesn't exist");
        logger.info(String.format("The picture from 'Did You Know' section were successfully captured and placed into 'target\\screenshot' folder"));
    }
}

package test.wikipediaTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.wikipediaPages.WikipediaHomePage;
import test.baseTest.BaseTest;

public class WikipediaScreenshotTest extends BaseTest {
    @Test
    public void wikipediaScreenshotIsPresentCheck() {
        int screenshotCapturedByAshot = new WikipediaHomePage(driver)
                .openWikipediaHomePage()
                .getImageWidthForScreenshotOfTheFirstDYKSectionElement();

        Assert.assertTrue(screenshotCapturedByAshot > 0, "The image doesn't exist");
        logger.info(String.format("The picture from 'Did You Know' section were successfully captured and placed into 'target\\screenshot' folder"));
    }
}
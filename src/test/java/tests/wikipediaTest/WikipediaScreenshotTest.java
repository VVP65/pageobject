package tests.wikipediaTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.wikipediaPages.WikipediaHomePage;
import tests.baseTest.BaseTest;

import java.io.IOException;

public class WikipediaScreenshotTest extends BaseTest {
    @Test
    public void wikipediaScreenshotIsPresentCheck() throws IOException {
        int screenshotCapturedByAshot = new WikipediaHomePage(driver)
                .openWikipediaHomePage()
                .getImageWidthForScreenshotOfTheFirstDYKSectionElement();

        logger.info(String.format("The picture from 'Did You Know' section were successfully captured and placed into 'target\\screenshot' folder"));
        Assert.assertTrue(screenshotCapturedByAshot > 0, "The image doesn't exist");
    }
}
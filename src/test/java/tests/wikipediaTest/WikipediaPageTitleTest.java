package tests.wikipediaTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.wikipediaPages.WikipediaHomePage;
import tests.BaseTest;

public class WikipediaPageTitleTest extends BaseTest {
    @Test
    public void wikipediaPageTitleTest() {
        String wikipediaPageTitle = new WikipediaHomePage(driver)
                .openWikipediaHomePage()
                .wikipediaHomePageTitle();

        logger.info(String.format("Wiki Page Title: %s", wikipediaPageTitle));
        Assert.assertTrue(wikipediaPageTitle.contains("Wikipedia, the free encyclopedia"), "Current page does not belong to Wikipedia project");
    }
}
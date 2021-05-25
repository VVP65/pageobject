package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.GoogleHomePage;

public class WikipediaGoogleSearchResultTest extends BaseTest {
    public WikipediaGoogleSearchResultTest(WebDriver driver) {
                super(driver);
    }

    @Test
    public void wikipediaGoogleSearchResultTest() {
        String wikipediaGoogleSearchResult = new GoogleHomePage(driver)
                .openGooglePage()
                .searchForTerms("wikipedia")
                .searchResultsForWikipediaPageURL();

        Assert.assertTrue(wikipediaGoogleSearchResult.contains("wikipedia.org"), "Google page does NOT contain 'wikipedia.org' text");
        logger.info(String.format("The current page URL: %s", wikipediaGoogleSearchResult));
    }
}
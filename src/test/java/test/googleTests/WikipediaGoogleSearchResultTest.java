package test.googleTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.googlePages.GoogleHomePage;
import test.baseTest.BaseTest;

public class WikipediaGoogleSearchResultTest extends BaseTest {
    @Test
    public void wikipediaGoogleSearchResultTest() {
        String wikipediaGoogleSearchResult = new GoogleHomePage(driver)
                .openGooglePage()
                .searchForTerms("wikipedia")
                .searchResultsForWikipediaPageURL();

        Assert.assertTrue(wikipediaGoogleSearchResult.contains("wikipedia.org"), "Google search result page does NOT contain 'wikipedia.org' text");
        logger.info(String.format("The current page URL: %s", wikipediaGoogleSearchResult));
    }
}
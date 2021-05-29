package test.googleTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.googlePages.GoogleHomePage;
import test.baseTest.BaseTest;

public class WikipediaGoogleSearchResultsPageLengthTest extends BaseTest {
    @Test
    public void wikipediaGoogleSearchResultsPageLength() {
        int wikipediaGoogleSearchResultPageLength = new GoogleHomePage(driver)
                .openGooglePage()
                .searchForTerms("wikipedia")
                .searchResultLength();

        logger.info(String.format("Wikipedia Google Search Result Page Length: %s", wikipediaGoogleSearchResultPageLength));
        Assert.assertTrue(wikipediaGoogleSearchResultPageLength > 0, "Google Search result for 'wikipedia' text does not contain expected text.");
    }
}
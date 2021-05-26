package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.GoogleHomePage;

public class WikipediaGoogleSearchResultsPageLengthTest extends BaseTest {

    @Test
    public void wikipediaGoogleSearchResultsPageLength() {
        int wikipediaGoogleSearchResultPageLength = new GoogleHomePage(driver)
                .openGooglePage()
                .searchForTerms("wikipedia")
                .searchResultLength();

        Assert.assertTrue(wikipediaGoogleSearchResultPageLength > 0, "Google Search result for 'wikipedia' text does not contain expected text.");
        logger.info(String.format("Wikipedia Google Search Result Page Length: %s", wikipediaGoogleSearchResultPageLength));
    }
}
package tests.googleTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.googlePages.GoogleHomePage;
import tests.BaseTest;

public class WikipediaGoogleSearchResultTest extends BaseTest {
    @Test
    public void wikipediaGoogleSearchResultCheck() {
        String wikipediaGoogleSearchResult = new GoogleHomePage(driver)
                .openGooglePage()
                .searchForTerms("wikipedia")
                .searchFirstLinkName();

        log.info(String.format("Wikipedia Google search result page URL : %s", wikipediaGoogleSearchResult));
        Assert.assertTrue(wikipediaGoogleSearchResult.contains("wikipedia.org"), "Google search result page does not contain 'wikipedia.org' text");
    }
}
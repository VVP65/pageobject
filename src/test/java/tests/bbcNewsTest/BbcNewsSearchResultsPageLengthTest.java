package tests.bbcNewsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.bbcNewsPages.BbcNewsHomePage;
import tests.BaseTest;

public class BbcNewsSearchResultsPageLengthTest extends BaseTest {
    @Test
    public void getBbcNewsSearchResultsPageLength(){
        int bbcNewsSearchResultsPageLength = new BbcNewsHomePage(driver)
                .openBbcNewsHomePage()
                .searchForTerms("Ukraine")
                .bbcNewsSearchResultPageLength();

        logger.info(String.format("BBC News Search Result Page Length: %s", bbcNewsSearchResultsPageLength));
        Assert.assertTrue(bbcNewsSearchResultsPageLength > 0, "BBC News search result for 'Ukraine' text does not contain expected text.");
    }
}
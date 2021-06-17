package tests.bbcNewsTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.bbcNewsPages.BbcNewsHomePage;
import tests.BaseTest;

public class BbcNewsSearchResultFirstLinkTest extends BaseTest {
    @Test
    public void getBbcNewsSearchResultFirstLink() {
        String bbcNewsSearchResultFirstLinkTest = new BbcNewsHomePage(driver)
                .openBbcNewsHomePage()
                .searchForTerms("Ukraine")
                .searchFirstLinkName();

        logger.info(String.format("BBC News first search result link name : %s", bbcNewsSearchResultFirstLinkTest));
        Assert.assertTrue(bbcNewsSearchResultFirstLinkTest.contains("Ukraine"), "BBC News first search result link name does not contain 'Ukraine' text");
    }
}
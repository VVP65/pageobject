package test.wikipediaTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.wikipediaPages.WikipediaHomePage;
import test.baseTest.BaseTest;

public class WikipediaSearchForTestAutomationResultsPageTest extends BaseTest {
    @Test
    public void searchForTestAutomationCheck() {
        String searchForTestAutomationSearch = new WikipediaHomePage(driver)
                .openWikipediaHomePage()
                .wikipediaSearchForTerms("Test Automation")
                .wikipediaSearchResultPageTitle();

        logger.info(String.format("Wikipedia search for Test Automation page result -  '%s'", searchForTestAutomationSearch));
        Assert.assertTrue(searchForTestAutomationSearch.contains("Test Automation"));
    }
}
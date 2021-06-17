package tests;

import org.testng.annotations.Test;
import pageobject.bbcNewsPages.BbcNewsHomePage;
import pageobject.googlePages.GoogleHomePage;
import pageobject.jQuerySortablePage.JquerySortablePage;
import pageobject.wikipediaPages.WikipediaHomePage;

public class NavigationTest extends BaseTest {
    @Test
    public void pagesNavigationAndVerificationCheck() {

        String googleHomePageTitle = new GoogleHomePage(driver)
                .openGooglePage()
                .getPageTitle();

        logger.info(String.format("Google Home Page Title: %s", googleHomePageTitle));
        softAssertion.assertTrue(googleHomePageTitle.contains("Google"), "Current page does not belong to Google Home Page");

        String wikipediaHomePageTitle = new WikipediaHomePage(driver)
                .openWikipediaHomePage()
                .getPageTitle();

        logger.info(String.format("Wikipedia Home Page Title: %s", wikipediaHomePageTitle));
        softAssertion.assertTrue(wikipediaHomePageTitle.contains("Wikipedia, the free encyclopedia"), "Current page does not belong to Wikipedia project");

        String bbcNewsHomePageTitle = new BbcNewsHomePage(driver)
                .openBbcNewsHomePage()
                .getPageTitle();

        logger.info(String.format("BBC News Home Page Title: %s", bbcNewsHomePageTitle));
        softAssertion.assertTrue(bbcNewsHomePageTitle.contains("BBC News"), "Current page does not belong to BBC news");

        String jQuerySortablePageTitle = new JquerySortablePage(driver)
                .openJquerySortablePage()
                .getPageTitle();

        logger.info(String.format("JQuery Sortable Page Title: %s", jQuerySortablePageTitle));
        softAssertion.assertTrue(jQuerySortablePageTitle.contains("Sortable | jQuery UI"), "Current page does not belong to JQuery 'Sortable' page");

        softAssertion.assertAll();
    }
}
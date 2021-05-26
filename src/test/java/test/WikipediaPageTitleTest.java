package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.GoogleHomePage;

public class WikipediaPageTitleTest extends BaseTest{

    @Test
    public void wikipediaPageTitleTest() {
        String wikipediaPageTitle = new GoogleHomePage(driver)
                .openGooglePage()
                .searchForTerms("wikipedia")
                .wikipediaPageTitle();

        Assert.assertTrue(wikipediaPageTitle.contains("Википедия - свободная энциклопедия"));
        logger.info(String.format("Wiki Page Title: %s", wikipediaPageTitle));
    }
}
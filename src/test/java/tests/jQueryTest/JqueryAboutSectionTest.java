package tests.jQueryTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.jQuerySortablePage.JquerySortablePage;
import tests.BaseTest;

public class JqueryAboutSectionTest extends BaseTest {
    @Test
    public void interactionsWithJqueryAboutSection() {
        String jqueryAboutSection = new JquerySortablePage(driver)
                .openJquerySortablePage()
                .jQueryAboutSectionText();

        logger.info(String.format("JQuery About section contains", jqueryAboutSection));
        Assert.assertTrue(jqueryAboutSection.contains("About"), "This section does not contain 'About'");
    }
}
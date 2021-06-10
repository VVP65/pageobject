package tests.jQueryTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.jQuerySortablePage.JquerySortablePage;
import tests.BaseTest;

public class JquerySortablePageTest extends BaseTest {
    @Test
    public void jquerySortablePage() throws InterruptedException {
        String jquerySortablePage = new JquerySortablePage(driver)
                .openJquerySortablePage()
                .jQuerySortablePageResult();

        logger.info(String.format("JQuery Sortable Page contains: %s", jquerySortablePage));
        Assert.assertTrue(jquerySortablePage.contains("Item 2"), "Current element is absent in this list");
    }
}
package tests.jQueryTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.jQuerySortablePage.JquerySortablePage;
import tests.BaseTest;

public class JquerySortablePageTest extends BaseTest {
    @Test
    public void jquerySortablePage() {
        String jquerySortablePage = new JquerySortablePage(driver)
                .openJquerySortablePage()
                .firstSortableElementText();

        logger.info(String.format("Sortable list contains %s", jquerySortablePage));
        Assert.assertTrue(jquerySortablePage.contains("Item 7"), "This element does not refer to first element in a sorted list");
    }
}
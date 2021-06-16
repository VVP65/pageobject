package tests.jQueryTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.jQuerySortablePage.JquerySortablePage;
import tests.BaseTest;

public class JquerySortablePageTest extends BaseTest {
    @Test
    public void checkPageElementsAfterSorting() {
        String firstSortableElementText = new JquerySortablePage(driver)
                .openJquerySortablePage()
                .highlightSortablePageElement()
                .getFirstSortableElementText();

        logger.info(String.format("Sortable list contains %s", firstSortableElementText));
        Assert.assertTrue(firstSortableElementText.contains("Item 7"), "This element does not refer to first element in a sorted list");
    }
}
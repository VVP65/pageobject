package tests.jQueryTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.jQuerySortablePage.JquerySortablePage;
import tests.BaseTest;

public class JquerySortablePageTest extends BaseTest {
    @Test
    public void afterSortingJQueryPageElementsCheck() {
        String firstSortableElementText = new JquerySortablePage(driver)
                .openJquerySortablePage()
                .highlightSortablePageElement()
                .getFirstSortableElementText();

        log.info(String.format("Sortable list contains %s", firstSortableElementText));
        Assert.assertTrue(firstSortableElementText.contains("Item 7"), "This element does not refer to first element in a sorted list");
    }
}
package je.techtribes.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PageSizeTests {

    @Test
    public void testCalculatePageSize() {
        assertEquals(4, PageSize.calculateNumberOfPages(100, 25));
        assertEquals(4, PageSize.calculateNumberOfPages(101, 28));
    }

    @Test
    public void testValidatePage_Returns1_WhenPageIsLessThan1() {
        assertEquals(1, PageSize.validatePage(-1, 100));
        assertEquals(1, PageSize.validatePage(0, 100));
    }

    @Test
    public void testValidatePage_ReturnsMaxPage_WhenPageIsTooHigh() {
        assertEquals(100, PageSize.validatePage(101, 100));
    }

    @Test
    public void testValidatePage_ReturnsPage_WhenPageIsInRange() {
        assertEquals(50, PageSize.validatePage(50, 100));
    }

}
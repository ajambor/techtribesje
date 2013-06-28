package je.techtribes.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the utilities in the StringUtils class.
 *
 * @author Simon Brown
 */
public class StringUtilsTests {

    @Test
    public void test_filterHTML() {
        assertEquals("Here is some text.", StringUtils.filterHtml("Here is <!-- <rdf>...</rdf> -->some text."));
        assertEquals("Here is some text.", StringUtils.filterHtml("Here is <!-- <rdf/> -->some text."));
        assertEquals("Here is some text.", StringUtils.filterHtml("<b>Here</b> is <i>some</i> text."));
        assertEquals("Here is a link.", StringUtils.filterHtml("Here is <a href=\"http://www.google.com\">a link</a>."));
        assertEquals("Here is a link.", StringUtils.filterHtml("Here is <a \nhref=\"http://www.google.com\">a link</a>."));
        assertEquals("Here is some text", StringUtils.filterHtml("Here is &lt;some&gt; text"));
    }

    @Test
    public void test_filterHtmlAndTruncate_ReturnsAnEmptyString_WhenNullIsPassed() {
        assertEquals("", StringUtils.filterHtmlAndTruncate(null));
    }

    @Test
    public void test_filterHtmlAndTruncate_ReturnsTheOriginalString_WhenItIsShorterThanTheMaxLength() {
        assertEquals("1234567890", StringUtils.filterHtmlAndTruncate("1234567890"));
        assertEquals("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 12345", StringUtils.filterHtmlAndTruncate("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 12345"));
    }

    @Test
    public void test_filterHtmlAndTruncate_ReturnsATruncatedString_WhenItIsLongerThanTheMaxLength() {
        assertEquals("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 12...", StringUtils.filterHtmlAndTruncate("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456"));
    }

}
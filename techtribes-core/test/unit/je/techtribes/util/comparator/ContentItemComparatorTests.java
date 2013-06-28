package je.techtribes.util.comparator;

import je.techtribes.domain.ContentItem;
import je.techtribes.domain.NewsFeedEntry;
import je.techtribes.util.comparator.ContentItemComparator;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class ContentItemComparatorTests {

    @Test
    public void testCompare_ANewerThanB_AIsFirst() throws Exception {
        Date dateA = new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse("29-Feb-2012 12:00");
        ContentItem a = new NewsFeedEntry("", "title", "body", dateA, null);

        Date dateB = new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse("28-Feb-2012 12:00");
        ContentItem b = new NewsFeedEntry("", "title", "body", dateB, null);

        ContentItemComparator comparator = new ContentItemComparator();
        assertTrue(comparator.compare(a, b) < 0);
        assertTrue(comparator.compare(b, a) > 0);
    }

}

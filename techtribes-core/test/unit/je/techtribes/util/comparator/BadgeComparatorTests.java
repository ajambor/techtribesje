package je.techtribes.util.comparator;

import je.techtribes.domain.badge.Badge;
import je.techtribes.domain.badge.MostActiveGoldBadge;
import je.techtribes.util.comparator.BadgeComparator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BadgeComparatorTests {

    @Test
    public void testCompare() throws Exception {
        BadgeComparator comparator = new BadgeComparator();

        Badge b1 = new MostActiveGoldBadge();
        b1.setOrder(1);

        Badge b2 = new MostActiveGoldBadge();
        b2.setOrder(2);

        assertTrue(comparator.compare(b1, b2) < 0);
        assertTrue(comparator.compare(b1, b1) == 0);
        assertTrue(comparator.compare(b2, b1) > 0);
    }

}

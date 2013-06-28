package je.techtribes.util.comparator;

import je.techtribes.domain.Person;
import je.techtribes.domain.badge.AwardedBadge;
import je.techtribes.domain.badge.Badge;
import je.techtribes.domain.badge.MostActiveGoldBadge;
import je.techtribes.util.comparator.AwardedBadgeComparator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AwardedBadgeComparatorTests {

    @Test
    public void testCompare() throws Exception {
        AwardedBadgeComparator comparator = new AwardedBadgeComparator();

        Person person = new Person(1);

        Badge b1 = new MostActiveGoldBadge();
        b1.setOrder(1);
        AwardedBadge aw1 = new AwardedBadge(b1, person);

        Badge b2 = new MostActiveGoldBadge();
        b2.setOrder(2);
        AwardedBadge aw2 = new AwardedBadge(b2, person);

        assertTrue(comparator.compare(aw1, aw2) < 0);
        assertTrue(comparator.compare(aw1, aw1) == 0);
        assertTrue(comparator.compare(aw2, aw1) > 0);
    }

}

package je.techtribes.util.comparator;

import je.techtribes.domain.Person;
import je.techtribes.util.comparator.ContentSourceByTwitterFollowersCountDescendingComparator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ContentSourceByTwitterFollowersCountDescendingComparatorTests {

    @Test
    public void test() {
        Person p1 = new Person();
        p1.setTwitterFollowersCount(999);

        Person p2 = new Person();
        p1.setTwitterFollowersCount(111);

        ContentSourceByTwitterFollowersCountDescendingComparator comparator = new ContentSourceByTwitterFollowersCountDescendingComparator();
        assertTrue(comparator.compare(p1, p2) < 0);
        assertTrue(comparator.compare(p1, p1) == 0);
        assertTrue(comparator.compare(p2, p1) > 0);
    }

}

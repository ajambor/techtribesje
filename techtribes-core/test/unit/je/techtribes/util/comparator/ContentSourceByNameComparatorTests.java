package je.techtribes.util.comparator;

import je.techtribes.domain.Person;
import je.techtribes.util.comparator.ContentSourceByNameComparator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ContentSourceByNameComparatorTests {

    @Test
    public void test() {
        Person p1 = new Person();
        p1.setName("AAA");

        Person p2 = new Person();
        p2.setName("BBB");

        ContentSourceByNameComparator comparator = new ContentSourceByNameComparator();
        assertTrue(comparator.compare(p1, p2) < 0);
        assertTrue(comparator.compare(p1, p1) == 0);
        assertTrue(comparator.compare(p2, p1) > 0);
    }

}

package je.techtribes.util.comparator;

import je.techtribes.domain.Activity;
import je.techtribes.domain.Person;
import je.techtribes.util.comparator.ActivityByScoreComparator;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class ActivityByScoreComparatorTests {

    @Test
    public void testCompare_SortsByScore_WhenScoresAreDifferent() throws Exception {
        ActivityByScoreComparator comparator = new ActivityByScoreComparator();

        Person person = new Person(1);
        Activity a1 = new Activity(person, 1, 1, 1, 1, 1);
        Activity a2 = new Activity(person, 0, 0, 0, 0, 0);

        assertTrue(comparator.compare(a1, a2) < 0);
        assertTrue(comparator.compare(a1, a1) == 0);
        assertTrue(comparator.compare(a2, a1) > 0);
    }

    @Test
    public void testCompare_SortsByLastActivityDate_WhenScoresAreTheSame() throws Exception {
        ActivityByScoreComparator comparator = new ActivityByScoreComparator();

        Person person = new Person(1);
        Activity a1 = new Activity(person, 1, 1, 1, 1, 1);
        a1.setLastActivityDate(new Date(12345));
        Activity a2 = new Activity(person, 1, 1, 1, 1, 1);
        a1.setLastActivityDate(new Date(54321));

        assertTrue(comparator.compare(a1, a2) < 0);
        assertTrue(comparator.compare(a1, a1) == 0);
        assertTrue(comparator.compare(a2, a1) > 0);
    }

}

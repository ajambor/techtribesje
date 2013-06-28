package je.techtribes.util.comparator;

import je.techtribes.domain.ContentSource;
import je.techtribes.domain.Person;
import je.techtribes.domain.ContentSourceStatistic;
import je.techtribes.util.comparator.ContentSourceStatisticComparator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ContentSourceStatisticComparatorTests {

    @Test
    public void testCompare_SortingIsHighestFirst_WhenContentSourceStatisticsHaveDifferentScores() {
        ContentSource cs1 = new Person();
        cs1.setName("A");
        ContentSource cs2 = new Person();
        cs2.setName("B");

        ContentSourceStatistic stat1 = new ContentSourceStatistic(cs1);
        stat1.incrementScore();
        ContentSourceStatistic stat2 = new ContentSourceStatistic(cs2);
        stat2.incrementScore();
        stat2.incrementScore();

        ContentSourceStatisticComparator comparator = new ContentSourceStatisticComparator();

        assertTrue(comparator.compare(stat1, stat1) == 0);
        assertTrue(comparator.compare(stat1, stat2) > 0);
        assertTrue(comparator.compare(stat2, stat1) < 0);
    }

    @Test
    public void testCompare_SortingIsAlphabetical_WhenContentSourceStatisticsHaveSameScores() {
        ContentSource cs1 = new Person();
        cs1.setName("A");
        ContentSource cs2 = new Person();
        cs2.setName("B");

        ContentSourceStatistic stat1 = new ContentSourceStatistic(cs1);
        stat1.incrementScore();
        ContentSourceStatistic stat2 = new ContentSourceStatistic(cs2);
        stat2.incrementScore();

        ContentSourceStatisticComparator comparator = new ContentSourceStatisticComparator();

        assertTrue(comparator.compare(stat1, stat1) == 0);
        assertTrue(comparator.compare(stat1, stat2) < 0);
        assertTrue(comparator.compare(stat2, stat1) > 0);
    }

}

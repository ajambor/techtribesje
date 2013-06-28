package je.techtribes.util.comparator;

import je.techtribes.domain.ContentSourceStatistic;

import java.util.Comparator;

/**
 * Compares ContentSourceStatistic objects, in reverse order of their score. If there scores are the same, they are
 * compared by name.
 */
public class ContentSourceStatisticComparator implements Comparator<ContentSourceStatistic> {

	public int compare(ContentSourceStatistic css1, ContentSourceStatistic css2) {
        if (css1.getScore() != css2.getScore()) {
		    return css2.getScore() - css1.getScore();
        } else {
            ContentSourceByNameComparator comparator = new ContentSourceByNameComparator();
            return comparator.compare(css1.getContentSource(), css2.getContentSource());
        }
	}

}
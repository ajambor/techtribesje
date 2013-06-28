package je.techtribes.util.comparator;

import je.techtribes.domain.ContentItem;

import java.util.Comparator;

/**
 * Compares content items, in reverse order of their timestamp.
 */
public class ContentItemComparator implements Comparator<ContentItem> {

	public int compare(ContentItem item1, ContentItem item2) {
		return item2.getTimestamp().compareTo(item1.getTimestamp());
	}

}
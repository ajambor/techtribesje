package je.techtribes.util.comparator;

import je.techtribes.domain.ContentSource;

import java.util.Comparator;

/**
 * Compares ContentSource objects by their name.
 */
public class ContentSourceByNameComparator implements Comparator<ContentSource> {

	public int compare(ContentSource cs1, ContentSource cs2) {
		return cs1.getName().compareTo(cs2.getName());
	}

}
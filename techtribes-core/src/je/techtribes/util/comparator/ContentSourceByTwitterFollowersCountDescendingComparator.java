package je.techtribes.util.comparator;

import je.techtribes.domain.ContentSource;

import java.util.Comparator;

/**
 * Compares ContentSource instances by their Twitter follower count (highest first).
 */
public class ContentSourceByTwitterFollowersCountDescendingComparator implements Comparator<ContentSource> {

    @Override
    public int compare(ContentSource cs1, ContentSource cs2) {
        return cs2.getTwitterFollowersCount() - cs1.getTwitterFollowersCount();
    }

}

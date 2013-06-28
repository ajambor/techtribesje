package je.techtribes.util.comparator;

import je.techtribes.domain.badge.Badge;

import java.util.Comparator;

/**
 * Compares Badge objects, by their sort order.
 */
public class BadgeComparator implements Comparator<Badge> {

    @Override
    public int compare(Badge badge1, Badge badge2) {
        return badge1.getOrder() - badge2.getOrder();
    }

}

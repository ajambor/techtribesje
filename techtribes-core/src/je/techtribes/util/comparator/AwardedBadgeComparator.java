package je.techtribes.util.comparator;

import je.techtribes.domain.badge.AwardedBadge;

import java.util.Comparator;

/**
 * Compares AwardedBadge objects, by the sort order of their associated Badge object.
 */
public class AwardedBadgeComparator implements Comparator<AwardedBadge> {

    @Override
    public int compare(AwardedBadge awardedBadge1, AwardedBadge awardedBadge2) {
        BadgeComparator comparator = new BadgeComparator();
        return comparator.compare(awardedBadge1.getBadge(), awardedBadge2.getBadge());
    }

}

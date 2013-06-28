package je.techtribes.component.badge;

import je.techtribes.domain.ContentSource;
import je.techtribes.domain.badge.AwardedBadge;

import java.util.List;

interface BadgeDao {

    List<AwardedBadge> getBadges();

    List<AwardedBadge> getBadges(ContentSource contentSource);

    void add(AwardedBadge badge);

    List<AwardedBadge> getRecentAwardedBadges(int pageSize);

}

package je.techtribes.domain.badge;

import je.techtribes.domain.Activity;
import je.techtribes.domain.ContentSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MostActiveBronzeBadge extends AbstractBadge implements ActivityBadge {

    public MostActiveBronzeBadge() {
        super(Badges.MOST_ACTIVE_BRONZE_ID, "Most Active - Bronze", "Top 3 on the <a href=\"/activity\">activity</a> page is still not to be sniffed at!");
    }

    @Override
    public Set<ContentSource> findEligibleContentSources(List<Activity> activityList) {
        Set<ContentSource> contentSources = new HashSet<>();

        if (activityList != null) {
            if (activityList.size() > 2) {
                contentSources.add(activityList.get(2).getContentSource());

            }
        }

        return contentSources;
    }

}

package je.techtribes.domain.badge;

import je.techtribes.domain.Activity;
import je.techtribes.domain.ContentSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MostActiveGoldBadge extends AbstractBadge implements ActivityBadge {

    public MostActiveGoldBadge() {
        super(Badges.MOST_ACTIVE_GOLD_ID, "Most Active - Gold", "This badge is awarded if you hit the top spot on the <a href=\"/activity\">activity</a> page.");
    }

    @Override
    public Set<ContentSource> findEligibleContentSources(List<Activity> activityList) {
        Set<ContentSource> contentSources = new HashSet<>();

        if (activityList != null) {
            if (activityList.size() > 0) {
                contentSources.add(activityList.get(0).getContentSource());

            }
        }

        return contentSources;
    }

}

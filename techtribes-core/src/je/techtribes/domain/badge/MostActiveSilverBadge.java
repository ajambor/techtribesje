package je.techtribes.domain.badge;

import je.techtribes.domain.Activity;
import je.techtribes.domain.ContentSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MostActiveSilverBadge extends AbstractBadge implements ActivityBadge {

    public MostActiveSilverBadge() {
        super(Badges.MOST_ACTIVE_SILVER_ID, "Most Active - Silver", "Can't hit the top spot? What about number 2 on the <a href=\"/activity\">activity</a> page?");
    }

    @Override
    public Set<ContentSource> findEligibleContentSources(List<Activity> activityList) {
        Set<ContentSource> contentSources = new HashSet<>();

        if (activityList != null) {
            if (activityList.size() > 1) {
                contentSources.add(activityList.get(1).getContentSource());

            }
        }

        return contentSources;
    }

}

package je.techtribes.domain.badge;

import je.techtribes.domain.Activity;
import je.techtribes.domain.ContentSource;

import java.util.List;
import java.util.Set;

public interface ActivityBadge extends Badge {

    public Set<ContentSource> findEligibleContentSources(List<Activity> activityList);

}

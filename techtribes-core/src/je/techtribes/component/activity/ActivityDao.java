package je.techtribes.component.activity;

import je.techtribes.domain.Activity;

import java.util.Collection;

public interface ActivityDao {

    void storeActivity(Collection<Activity> activityCollection);

    Collection<Activity> getRecentActivity();

}

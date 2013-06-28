package je.techtribes.domain.badge;

import je.techtribes.domain.Activity;
import org.junit.Before;

import java.util.LinkedList;
import java.util.List;

public abstract class ActivityBadgeTestsSupport extends BadgeTestsSupport {

    protected List<Activity> activityList;

    @Before
    public void setUp() {
        activityList = new LinkedList<>();
        activityList.add(new Activity(person1, 1, 1, 1, 1, 1));
        activityList.add(new Activity(person2, 1, 1, 1, 1, 1));
        activityList.add(new Activity(person3, 1, 1, 1, 1, 1));
    }

    protected abstract ActivityBadge createBadge();

}

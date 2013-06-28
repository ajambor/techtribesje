package je.techtribes.domain.badge;

import je.techtribes.domain.ContentSource;
import je.techtribes.domain.ContentSourceType;
import je.techtribes.domain.Person;
import je.techtribes.domain.Tribe;
import org.junit.Before;

public abstract class BadgeTestsSupport {

    protected Tribe tribe1, tribe2, tribe3;
    protected Person person1, person2, person3;

    @Before
    public void setUp() {
        person1 = new Person(1);
        person1.setName("Person 1");
        person2 = new Person(2);
        person2.setName("Person 2");
        person3 = new Person(3);
        person3.setName("Person 3");

        tribe1 = new Tribe(ContentSourceType.Business, 4);
        tribe1.setName("Tribe 1");
        tribe2 = new Tribe(ContentSourceType.Community, 5);
        tribe2.setName("Tribe 5");
        tribe3 = new Tribe(ContentSourceType.Tech, 6);
        tribe3.setName("Tribe 3");
    }

}

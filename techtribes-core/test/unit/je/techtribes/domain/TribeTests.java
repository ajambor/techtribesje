package je.techtribes.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TribeTests {

    private Tribe tribe;
    
    @Before
    public void setUp() {
        tribe = new Tribe(ContentSourceType.Business);
    }

    @Test
    public void testGetType() {
        tribe = new Tribe(ContentSourceType.Business);
        assertEquals(ContentSourceType.Business, tribe.getType());

        tribe = new Tribe(ContentSourceType.Community);
        assertEquals(ContentSourceType.Community, tribe.getType());
    }

    @Test
    public void testIsPerson() {
        assertFalse(tribe.isPerson());
    }

    @Test
    public void testIsTribe() {
        assertTrue(tribe.isTribe());
    }

    @Test
    public void testGetNumberOfMembers() {
        assertEquals(0, tribe.getNumberOfMembers());

        tribe.add(new Person());
        assertEquals(1, tribe.getNumberOfMembers());
    }

    @Test
    public void testAddMember() {
        Person person1 = new Person(1);
        person1.setName("Person 1");

        assertEquals(0, tribe.getNumberOfMembers());

        tribe.add(person1);
        assertEquals(1, tribe.getNumberOfMembers());
        assertSame(person1, tribe.getMembers().toArray()[0]);

        // add the same person again
        tribe.add(person1);
        assertEquals(1, tribe.getNumberOfMembers());

        Person person2 = new Person(2);
        person2.setName("Person 2");
        tribe.add(person2);
        assertEquals(2, tribe.getNumberOfMembers());
        assertSame(person2, tribe.getMembers().toArray()[1]);

    }

    @Test
    public void testRemoveMember() {
        Person person1 = new Person(1);
        person1.setName("Person 1");
        tribe.add(person1);

        Person person2 = new Person(2);
        person2.setName("Person 2");
        tribe.add(person2);

        assertEquals(2, tribe.getNumberOfMembers());
        assertSame(person2, tribe.getMembers().toArray()[1]);

        tribe.remove(person1);
        assertEquals(1, tribe.getNumberOfMembers());
        assertSame(person2, tribe.getMembers().toArray()[0]);

        // remove the same person again
        tribe.remove(person1);
        assertEquals(1, tribe.getNumberOfMembers());
    }

    @Test
    public void testHasMember() {
        Person person1 = new Person(1);
        person1.setName("Person 1");

        Person person2 = new Person(2);
        person2.setName("Person 2");

        tribe.add(person1);

        assertTrue(tribe.hasMember(person1));
        assertFalse(tribe.hasMember(person2));
    }

    @Test
    public void testSetMembers() {
        List<Person> people = new LinkedList<>();
        Person person1 = new Person(1);
        person1.setName("Person 1");
        people.add(person1);
        people.add(person1); // check that duplicates aren't allowed

        Person person2 = new Person(2);
        person2.setName("Person 2");
        people.add(person2);

        assertEquals(0, tribe.getNumberOfMembers());
        tribe.setMembers(people);

        assertEquals(2, tribe.getNumberOfMembers());
        assertSame(person1, tribe.getMembers().toArray()[0]);
        assertSame(person2, tribe.getMembers().toArray()[1]);
    }

}

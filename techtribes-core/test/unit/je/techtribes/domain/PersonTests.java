package je.techtribes.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTests {

    private Person person;
    
    @Before
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testGetType() {
        assertEquals(ContentSourceType.Person, person.getType());
    }

    @Test
    public void testIsPerson() {
        assertTrue(person.isPerson());
    }

    @Test
    public void testIsTribe() {
        assertFalse(person.isTribe());
    }

    @Test
    public void testAddTribes() {
        assertEquals(0, person.getNumberOfTribes());

        Tribe tribe1 = new Tribe(ContentSourceType.Business, 1);
        tribe1.setName("tribe1");
        person.add(tribe1);
        assertEquals(1, person.getNumberOfTribes());
        assertSame(tribe1, person.getTribes().toArray()[0]);

        // add the same tribe again
        person.add(tribe1);
        assertEquals(1, person.getNumberOfTribes());

        Tribe tribe2 = new Tribe(ContentSourceType.Tech, 2);
        tribe2.setName("tribe2");
        person.add(tribe2);
        assertEquals(2, person.getNumberOfTribes());
        assertSame(tribe2, person.getTribes().toArray()[1]);
    }

    @Test
    public void testRemoveTribes() {
        Tribe tribe1 = new Tribe(ContentSourceType.Business, 1);
        tribe1.setName("tribe1");
        person.add(tribe1);

        Tribe tribe2 = new Tribe(ContentSourceType.Tech, 2);
        tribe2.setName("tribe2");
        person.add(tribe2);

        assertEquals(2, person.getNumberOfTribes());

        person.remove(tribe1);
        assertEquals(1, person.getNumberOfTribes());
        assertSame(tribe2, person.getTribes().toArray()[0]);

        // remove the same tribe again
        person.remove(tribe1);
        assertEquals(1, person.getNumberOfTribes());
    }

    @Test
    public void testIsAMemberOf() {
        Tribe tribe1 = new Tribe(ContentSourceType.Business, 1);
        tribe1.setName("tribe1");
        assertFalse(person.isAMemberOf(tribe1));

        person.add(tribe1);
        assertTrue(person.isAMemberOf(tribe1));
    }

}

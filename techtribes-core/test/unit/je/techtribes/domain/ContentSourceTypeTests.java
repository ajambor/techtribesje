package je.techtribes.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContentSourceTypeTests {

    @Test
    public void testLookupByCharacter() {
        assertEquals(ContentSourceType.Person, ContentSourceType.lookupByChar('p'));
        assertEquals(ContentSourceType.Business, ContentSourceType.lookupByChar('b'));
        assertEquals(ContentSourceType.Tech, ContentSourceType.lookupByChar('t'));
        assertEquals(ContentSourceType.Media, ContentSourceType.lookupByChar('m'));
        assertEquals(ContentSourceType.Community, ContentSourceType.lookupByChar('c'));
    }

    @Test
    public void testLookupByCharacter_ReturnsPerson_WhenGivenAnInvalidType() {
        assertEquals(ContentSourceType.Person, ContentSourceType.lookupByChar('x'));
    }

    @Test
    public void testToChar() {
        assertEquals("p", ContentSourceType.Person.toChar());
        assertEquals("b", ContentSourceType.Business.toChar());
        assertEquals("t", ContentSourceType.Tech.toChar());
        assertEquals("m", ContentSourceType.Media.toChar());
        assertEquals("c", ContentSourceType.Community.toChar());
    }

}

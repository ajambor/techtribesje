package je.techtribes.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IslandTests {

    @Test
    public void testLookup() {
        assertEquals(Island.Jersey, Island.lookup("jersey"));
        assertEquals(Island.Jersey, Island.lookup("JERSEY"));
        assertEquals(Island.Jersey, Island.lookup("Jersey"));

        assertEquals(Island.Guernsey, Island.lookup("guernsey"));
        assertEquals(Island.Guernsey, Island.lookup("GUERNSEY"));
        assertEquals(Island.Guernsey, Island.lookup("Guernsey"));
    }

    @Test
    public void testLookupByCharacter() {
        assertEquals(Island.None, Island.lookupByChar(null));
        assertEquals(Island.None, Island.lookupByChar(""));
        assertEquals(Island.Jersey, Island.lookupByChar("Jersey"));
        assertEquals(Island.Jersey, Island.lookupByChar("jersey"));
        assertEquals(Island.Guernsey, Island.lookupByChar("Guernsey"));
        assertEquals(Island.Guernsey, Island.lookupByChar("guernsey"));
    }

    @Test
    public void testToChar() {
        assertEquals("j", Island.Jersey.toChar());
        assertEquals("g", Island.Guernsey.toChar());
        assertNull(Island.None.toChar());
    }

}

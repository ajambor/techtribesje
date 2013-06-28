package je.techtribes.domain;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ContentSourceTests {

    private Person person;
    
    @Before
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testGetAndSetName() {
        person.setName("Simon Brown");
        assertEquals("Simon Brown", person.getName());
    }

    @Test
    public void testGetShortName_ReturnsNameInLowerCase() {
        person.setName("Simon");
        assertEquals("simon", person.getShortName());
    }

    @Test
    public void testGetShortName_ReturnsTheNameInLowerCaseAndWithoutSpaces_WhenTheNameHasSpaces() {
        person.setName("Simon Brown");
        assertEquals("simonbrown", person.getShortName());
    }

    @Test
    public void testGetShortName_ReturnsTheNameInLowerCaseAndWithoutSpaces_WhenTheNameHasMultipleSpaces() {
        person.setName("Crowd Media Ltd");
        assertEquals("crowdmedialtd", person.getShortName());
    }

    @Test
    public void testGetShortName_ReturnsTheNameInLowerCaseAndWithoutHyphens_WhenTheNameHasHyphens() {
        person.setName("E-scape Interactive");
        assertEquals("e-scapeinteractive", person.getShortName());
    }

    @Test
    public void testGetShortName_ReturnsTheNameInLowerCaseAndWithoutApostrophes_WhenTheNameHasApostrophes() {
        person.setName("James O'Garra");
        assertEquals("jamesogarra", person.getShortName());
    }

    @Test
    public void testGetShortName_ReturnsTheNameInLowerCaseAndWithoutDots_WhenTheNameHasDots() {
        person.setName("Prosperity 24.7");
        assertEquals("prosperity247", person.getShortName());
    }

    @Test
    public void testGetName_ReturnsEmptyString_WhenNameIsSetToNull() {
        person.setName(null);
        assertEquals("", person.getName());
    }

    @Test
    public void testGetAndSetTwitterId() {
        person.setTwitterId("simonbrown");
        assertEquals("simonbrown", person.getTwitterId());
    }

    @Test
    public void testHasTwitterId() {
        assertFalse(person.hasTwitterId());

        person.setTwitterId("");
        assertFalse(person.hasTwitterId());

        person.setTwitterId("simonbrown");
        assertTrue(person.hasTwitterId());
    }

    @Test
    public void testGetAndSetGitHubId() {
        person.setGitHubId("simonbrowngotje");
        assertEquals("simonbrowngotje", person.getGitHubId());
    }

    @Test
    public void testHasGitHubId() {
        assertFalse(person.hasGitHubId());

        person.setGitHubId("");
        assertFalse(person.hasGitHubId());

        person.setGitHubId("simonbrowndotje");
        assertTrue(person.hasGitHubId());
    }

    @Test
    public void testGetAndSetIsland() {
        person.setIsland(Island.Jersey);
        assertEquals(Island.Jersey, person.getIsland());
    }

    @Test
    public void testGetAndSetProfile() {
        person.setProfile("Some profile text");
        assertEquals("Some profile text", person.getProfile());
    }

    @Test
    public void testGetAndSetProfileImageUrl() throws Exception {
        person.setProfileImageUrl(new URL("http://www.google.com"));
        assertEquals(new URL("http://www.google.com"), person.getProfileImageUrl());
    }

    @Test
    public void testGetAndSetUrl() throws Exception {
        person.setUrl(new URL("http://www.google.com"));
        assertEquals(new URL("http://www.google.com"), person.getUrl());
    }

    @Test
    public void testCompareTo() {
        Person p1 = new Person();
        p1.setName("AAA");

        Person p2 = new Person();
        p2.setName("BBB");

        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p1.compareTo(p1) == 0);
        assertTrue(p2.compareTo(p1) > 0);
    }

    @Test
    public void testGetAndSetTwitterFollowersCount() {
        person.setTwitterFollowersCount(1234);
        assertEquals(1234, person.getTwitterFollowersCount());
    }

    @Test
    public void testGetAndSetContentAggregated() {
        person.setContentAggregated(true);
        assertTrue(person.isContentAggregated());
    }

    @Test
    public void testGetAndSetSignedInBefore() {
        person.setSignedInBefore(true);
        assertTrue(person.hasSignedInBefore());
    }

    @Test
    public void testGetAndSetActive() {
        person.setActive(true);
        assertTrue(person.isActive());
    }

    @Test
    public void testAddNewsFeed() throws Exception {
        assertTrue(person.getNewsFeeds().isEmpty());
        person.addNewsFeed("http://www.google.com/rss");
        assertEquals(1, person.getNewsFeeds().size());
        assertEquals(new URL("http://www.google.com/rss"), ((NewsFeed) person.getNewsFeeds().toArray()[0]).getUrl());
    }

    @Test
    public void testAddNewsFeed_DoesntAddNewsFeed_WhenTheUrlIsNull() throws Exception {
        assertTrue(person.getNewsFeeds().isEmpty());
        person.addNewsFeed(null);
        assertTrue(person.getNewsFeeds().isEmpty());
    }

    @Test
    public void testAddNewsFeed_DoesntAddNewsFeed_WhenTheUrlIsMalformed() throws Exception {
        assertTrue(person.getNewsFeeds().isEmpty());
        person.addNewsFeed("htt://www.google.com/rss");
        assertTrue(person.getNewsFeeds().isEmpty());
    }

}

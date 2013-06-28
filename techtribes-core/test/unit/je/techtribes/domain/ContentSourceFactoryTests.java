package je.techtribes.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ContentSourceFactoryTests {

    @Test
    public void testCreatePerson() {
        assertThat(ContentSourceFactory.create(ContentSourceType.Person), instanceOf(Person.class));
    }

    @Test
    public void testCreateBusinessTribe() {
        assertThat(ContentSourceFactory.create(ContentSourceType.Business), instanceOf(Tribe.class));
    }

    @Test
    public void testCreateTechTribe() {
        assertThat(ContentSourceFactory.create(ContentSourceType.Tech), instanceOf(Tribe.class));
    }

    @Test
    public void testCreateMediaTribe() {
        assertThat(ContentSourceFactory.create(ContentSourceType.Media), instanceOf(Tribe.class));
    }

    @Test
    public void testCreateCommunityTribe() {
        assertThat(ContentSourceFactory.create(ContentSourceType.Community), instanceOf(Tribe.class));
    }

    @Test
    public void testCreatePersonWithSpecificId() {
        assertEquals(14, ContentSourceFactory.create(ContentSourceType.Person, 14).getId());
    }

    @Test
    public void testCreateTribeWithSpecificId() {
        assertEquals(42, ContentSourceFactory.create(ContentSourceType.Community, 42).getId());
    }

}

package je.techtribes.domain;

import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TwitterProfileTests {

    @Test
    public void testProperties() throws Exception {
        TwitterProfile profile = new TwitterProfile("simonbrown");
        profile.setDescription("My twitter profile");
        profile.setImageUrl(new URL("http://twitter.com/simonbrown.jpg"));
        profile.setUrl(new URL("http://www.simonbrown.je"));

        assertEquals("simonbrown", profile.getTwitterId());
        assertEquals("My twitter profile", profile.getDescription());
        assertEquals(new URL("http://twitter.com/simonbrown.jpg"), profile.getImageUrl());
        assertEquals(new URL("http://www.simonbrown.je"), profile.getUrl());
    }

}

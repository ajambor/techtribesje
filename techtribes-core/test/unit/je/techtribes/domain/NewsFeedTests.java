package je.techtribes.domain;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class NewsFeedTests {

    private ContentSource contentSource;
    private NewsFeed newsFeed;
    
    @Before
    public void setUp() throws Exception {
        contentSource = new Person();
        newsFeed = new NewsFeed("http://www.google.com/rss", contentSource);
    }

    @Test
    public void testGetUrl() throws Exception {
        assertEquals(new URL("http://www.google.com/rss"), newsFeed.getUrl());
    }

    @Test
    public void testGetContentSource() {
        assertSame(contentSource, newsFeed.getContentSource());
    }

    @Test
    public void testGetAndSetTitle() {
        newsFeed.setTitle("Some title");
        assertEquals("Some title", newsFeed.getTitle());
    }

}

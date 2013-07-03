package je.techtribes.web.controller;

import je.techtribes.component.newsfeedentry.NewsFeedEntryComponent;
import je.techtribes.domain.ContentSource;
import je.techtribes.domain.NewsFeedEntry;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RssControllerTests {

    @Test
    public void test_generateRssFeed() {
        RssController controller = new RssController(createNewsFeedEntryComponent());

        ModelMap model = new ModelMap();
        View view = controller.generateRssFeed(model);

        List<NewsFeedEntry> newsFeedEntries = (List<NewsFeedEntry>)model.get("newsFeedEntries");
        assertEquals(12, newsFeedEntries.size());

        assertTrue(view instanceof InternalResourceView);
        assertEquals("/WEB-INF/views-xml/rss.jsp", ((InternalResourceView)view).getUrl());
    }

    private NewsFeedEntryComponent createNewsFeedEntryComponent() {
        return new NewsFeedEntryComponent() {
            @Override
            public List<NewsFeedEntry> getRecentNewsFeedEntries(int page, int pageSize) {
                List<NewsFeedEntry> newsFeedEntries = new LinkedList<>();
                for (int i = 0; i < pageSize; i++) {
                    newsFeedEntries.add(new NewsFeedEntry("http://somedomain.com", "Title", "Body", new Date(), i));
                }
                return newsFeedEntries;
            }

            @Override
            public List<NewsFeedEntry> getRecentNewsFeedEntries(ContentSource contentSource, int pageSize) {
                return null;
            }

            @Override
            public List<NewsFeedEntry> getRecentNewsFeedEntries(Collection<ContentSource> contentSources, int page, int pageSize) {
                return null;
            }

            @Override
            public long getNumberOfNewsFeedEntries(ContentSource contentSource, Date start, Date end) {
                return 0;
            }

            @Override
            public long getNumberOfNewsFeedEntries() {
                return 0;
            }

            @Override
            public long getNumberOfNewsFeedEntries(Collection<ContentSource> contentSources) {
                return 0;
            }

            @Override
            public void storeNewsFeedEntries(Collection<NewsFeedEntry> newsFeedEntries) {
            }
        };
    }
}

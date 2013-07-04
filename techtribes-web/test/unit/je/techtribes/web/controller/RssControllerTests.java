package je.techtribes.web.controller;

import je.techtribes.domain.ContentSource;
import je.techtribes.domain.NewsFeedEntry;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RssControllerTests extends AbstractControllerTests {

    @Test
    public void test_generateRssFeed() {
        RssController controller = new RssController(createNewsFeedEntryComponent());
        controller.setContentSourceComponent(createContentSourceComponent());

        ModelMap model = new ModelMap();
        View view = controller.generateRssFeed(model);

        List<ContentSource> peopleAndTribes = (List<ContentSource>)model.get("peopleAndTribes");
        assertEquals(100, peopleAndTribes.size());

        List<NewsFeedEntry> newsFeedEntries = (List<NewsFeedEntry>)model.get("newsFeedEntries");
        assertEquals(12, newsFeedEntries.size());

        assertTrue(view instanceof InternalResourceView);
        assertEquals("/WEB-INF/views-xml/rss.jsp", ((InternalResourceView)view).getUrl());
    }

}

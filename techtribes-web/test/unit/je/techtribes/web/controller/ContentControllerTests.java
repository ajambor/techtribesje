package je.techtribes.web.controller;

import je.techtribes.domain.ContentSource;
import je.techtribes.domain.NewsFeedEntry;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ContentControllerTests extends AbstractControllerTestsBase {

    @Test
    public void test_viewRecentContent_Page1() {
        ContentController controller = new ContentController(new NewsFeedEntryComponentStub());
        controller.setContentSourceComponent(new ContentSourceComponentStub());

        ModelMap model = new ModelMap();
        String view = controller.viewRecentContent(model);
        assertEquals("content", view);

        List<NewsFeedEntry> newsFeedEntries = (List<NewsFeedEntry>)model.get("newsFeedEntries");
        assertEquals(12, newsFeedEntries.size());
        int i = 1;
        for (NewsFeedEntry newsFeedEntry : newsFeedEntries) {
            assertEquals("http://somedomain.com/" + i, newsFeedEntry.getPermalink());
            i++;
        }

        assertEquals(1, model.get("currentPage"));
        assertEquals(100, model.get("maxPage"));
        assertEquals("techtribes.je - Content - 1", model.get("pageTitle"));
        assertEquals(100, ((Collection<ContentSource>) model.get("peopleAndTribes")).size());
    }

}

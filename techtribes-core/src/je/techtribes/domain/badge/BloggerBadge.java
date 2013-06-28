package je.techtribes.domain.badge;

import je.techtribes.domain.ContentSource;
import je.techtribes.domain.NewsFeedEntry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BloggerBadge extends AbstractBadge implements ContentBadge {

    public BloggerBadge() {
        super(Badges.BLOGGER_ID, "Blogger", "This badge is awarded to those that share their knowledge, experience and news via a blog.");
    }

    @Override
    public Set<ContentSource> findEligibleContentSources(Collection<NewsFeedEntry> newsFeedEntries) {
        Set<ContentSource> contentSources = new HashSet<>();
        if (newsFeedEntries != null) {
            for (NewsFeedEntry newsFeedEntry : newsFeedEntries) {
                contentSources.add(newsFeedEntry.getContentSource());
            }
        }

        return contentSources;
    }

}

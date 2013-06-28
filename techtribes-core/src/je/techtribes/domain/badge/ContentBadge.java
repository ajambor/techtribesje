package je.techtribes.domain.badge;

import je.techtribes.domain.ContentSource;
import je.techtribes.domain.NewsFeedEntry;

import java.util.Collection;
import java.util.Set;

public interface ContentBadge extends Badge {

    public Set<ContentSource> findEligibleContentSources(Collection<NewsFeedEntry> newsFeedEntries);

}

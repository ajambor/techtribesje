package je.techtribes.domain.badge;

import je.techtribes.domain.ContentSource;

import java.util.Collection;
import java.util.Set;

public interface ContentSourceBadge extends Badge {

    public Set<ContentSource> findEligibleContentSources(Collection<ContentSource> contentSources);

}

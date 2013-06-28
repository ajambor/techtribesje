package je.techtribes.util;

import je.techtribes.domain.ContentSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ContentSourceToIdConverter {

    public Collection<Integer> getIds(Collection<ContentSource> contentSources) {
        Set<Integer> contentSourceIds = new HashSet<>();
        for (ContentSource contentSource : contentSources) {
            contentSourceIds.add(contentSource.getId());
        }

        return contentSourceIds;
    }

}

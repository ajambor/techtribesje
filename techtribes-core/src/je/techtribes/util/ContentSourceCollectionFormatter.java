package je.techtribes.util;

import je.techtribes.domain.ContentSource;

import java.util.Collection;

public class ContentSourceCollectionFormatter {

    public static String format(Collection<ContentSource> contentSources) {
        StringBuilder builder = new StringBuilder();

        for (ContentSource contentSource : contentSources) {
            builder.append(contentSource.getName());
            builder.append(" ");
        }

        return builder.toString();
    }



}

package je.techtribes.domain;

import je.techtribes.util.comparator.ContentSourceStatisticComparator;

import java.util.*;

public class ContentSourceStatistics {

    private List<? extends ContentItem> contentItems;
    private List<ContentSourceStatistic> statistics;

    public ContentSourceStatistics(List<? extends ContentItem> contentItems) {
        this.contentItems = contentItems;

        calculateStatistics();
    }

    public List<ContentSourceStatistic> getStatistics() {
        return new LinkedList<>(statistics);
    }

    private void calculateStatistics() {
        Map<ContentSource, ContentSourceStatistic> map = new HashMap<>();

        int total = contentItems.size();

        for (ContentItem item : contentItems) {
            ContentSourceStatistic stat = new ContentSourceStatistic(item.getContentSource());
            if (map.containsKey(stat.getContentSource())) {
                stat = map.get(stat.getContentSource());
            } else {
                map.put(stat.getContentSource(), stat);
            }
            stat.incrementScore();
        }

        statistics = new LinkedList<>(map.values());
        Collections.sort(statistics, new ContentSourceStatisticComparator());

        for (ContentSourceStatistic stat : statistics) {
            stat.calculatePercentage(total);
        }
    }

}

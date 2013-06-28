package je.techtribes.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Activity {

    public static final int LOCAL_TALK_SCORE = 50;
    public static final int INTERNATIONAL_TALK_SCORE = 100;
    public static final int CONTENT_SCORE = 25;
    public static final int TWEET_SCORE = 1;
    public static final int EVENT_SCORE = 100;

    public static final int MAXIMUM_TWEET_SCORE = 25;

    private int contentSourceId;
    private ContentSource contentSource;

    private long numberOfLocalTalks;
    private long numberOfInternationalTalks;
    private long numberOfNewsFeedEntries;
    private long numberOfTweets;
    private long numberOfEvents;

    private Date lastActivityDate = new Date(0);

    private List<Activity> activityList = new LinkedList<>();

    public Activity(int contentSourceId, long numberOfInternationalTalks, long numberOfLocalTalks, long numberOfNewsFeedEntries, long numberOfTweets, long numberOfEvents, Date lastActivityDate) {
        this.contentSourceId = contentSourceId;
        this.numberOfLocalTalks = numberOfLocalTalks;
        this.numberOfInternationalTalks = numberOfInternationalTalks;
        this.numberOfNewsFeedEntries = numberOfNewsFeedEntries;
        this.numberOfTweets = numberOfTweets;
        this.numberOfEvents = numberOfEvents;
        this.lastActivityDate = lastActivityDate;
    }

    public Activity(ContentSource contentSource, long numberOfInternationalTalks, long numberOfLocalTalks, long numberOfNewsFeedEntries, long numberOfTweets, long numberOfEvents) {
        this.contentSource = contentSource;
        this.numberOfLocalTalks = numberOfLocalTalks;
        this.numberOfInternationalTalks = numberOfInternationalTalks;
        this.numberOfNewsFeedEntries = numberOfNewsFeedEntries;
        this.numberOfTweets = numberOfTweets;
        this.numberOfEvents = numberOfEvents;
    }

    public int getContentSourceId() {
        return contentSourceId;
    }

    public void setContentSource(ContentSource contentSource) {
        this.contentSource = contentSource;
    }

    public ContentSource getContentSource() {
        return contentSource;
    }

    public long getNumberOfLocalTalks() {
        long number = numberOfLocalTalks;

        for (Activity activity : activityList) {
            number += activity.getNumberOfLocalTalks();
        }

        return number;
    }

    public long getNumberOfInternationalTalks() {
        long number = numberOfInternationalTalks;

        for (Activity activity : activityList) {
            number += activity.getNumberOfInternationalTalks();
        }

        return number;
    }

    public long getNumberOfNewsFeedEntriesWithoutAggregration() {
        return this.numberOfNewsFeedEntries;
    }

    public long getNumberOfNewsFeedEntries() {
        long number = numberOfNewsFeedEntries;

        for (Activity activity : activityList) {
            number += activity.getNumberOfNewsFeedEntries();
        }

        return number;
    }

    public long getNumberOfTweets() {
        long number = numberOfTweets;

        for (Activity activity : activityList) {
            number += activity.getNumberOfTweets();
        }

        return number;
    }

    public long getNumberOfEvents() {
        long number = numberOfEvents;

        for (Activity activity : activityList) {
            number += activity.getNumberOfEvents();
        }

        return number;
    }

    public void addFiguresFrom(Activity activity) {
        if (activity.getLastActivityDate().after(lastActivityDate)) {
            this.lastActivityDate = activity.getLastActivityDate();
        }

        this.activityList.add(activity);
    }

    public double getScore() {
        return getRawScore();
    }

    public long getRawScore() {
        return getInternationalTalkScore() + getLocalTalkScore() + getNewsFeedEntryScore() + getTwitterScore() + getEventScore();
    }

    public long getLocalTalkScore() {
        long score = this.numberOfLocalTalks * LOCAL_TALK_SCORE;

        for (Activity activity : activityList) {
            score += activity.getLocalTalkScore();
        }

        return score;
    }

    public long getInternationalTalkScore() {
        long score = this.numberOfInternationalTalks * INTERNATIONAL_TALK_SCORE;

        for (Activity activity : activityList) {
            score += activity.getInternationalTalkScore();
        }

        return score;
    }

    public long getNewsFeedEntryScore() {
        long score = this.numberOfNewsFeedEntries * CONTENT_SCORE;

        for (Activity activity : activityList) {
            score += activity.getNewsFeedEntryScore();
        }

        return score;
    }

    public long getTwitterScore() {
        long tweets = this.numberOfTweets;

        for (Activity activity : activityList) {
            tweets += activity.getNumberOfTweets();
        }

        return Math.min(MAXIMUM_TWEET_SCORE, tweets * TWEET_SCORE);
    }

    public long getEventScore() {
        // only community tribes get points for events
        if (contentSource.isTribe()) {
            Tribe tribe = (Tribe)contentSource;

            if (tribe.getType() == ContentSourceType.Community) {
                long score = this.numberOfEvents * EVENT_SCORE;

                for (Activity activity : activityList) {
                    score += activity.getEventScore();
                }

                return score;
            }
        }

        return 0;
    }

    public Date getLastActivityDate() {
        Date last = this.lastActivityDate;

        for (Activity activity : activityList) {
            if (activity.getLastActivityDate().after(last)) {
                last = activity.getLastActivityDate();
            }
        }
        return last;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

}

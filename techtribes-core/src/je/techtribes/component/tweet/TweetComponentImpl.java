package je.techtribes.component.tweet;

import je.techtribes.component.AbstractComponent;
import je.techtribes.component.contentsource.ContentSourceComponent;
import je.techtribes.domain.ContentSource;
import je.techtribes.domain.Tweet;
import je.techtribes.util.ContentItemFilter;
import je.techtribes.util.ContentSourceCollectionFormatter;
import je.techtribes.util.PageSize;

import java.util.Collection;
import java.util.Date;
import java.util.List;

class TweetComponentImpl extends AbstractComponent implements TweetComponent {

    private ContentSourceComponent contentSourceComponent;
    private TweetDao tweetDao;

    public TweetComponentImpl(TweetDao tweetDao, ContentSourceComponent contentSourceComponent) {
        this.tweetDao = tweetDao;
        this.contentSourceComponent = contentSourceComponent;
    }

    @Override
    public List<Tweet> getRecentTweets(int page, int pageSize) {
        try {
            page = PageSize.validatePage(page);
            pageSize = PageSize.validatePageSize(pageSize);
            List<Tweet> tweets = tweetDao.getRecentTweets(page, pageSize);
            filterAndEnrich(tweets);
            return tweets;
        } catch (Exception e) {
            TweetException te = new TweetException("Error while retrieving recent tweets for page " + page, e);
            logError(te);
            throw te;
        }
    }

    @Override
    public List<Tweet> getRecentTweets(ContentSource contentSource, int pageSize) {
        try {
            pageSize = PageSize.validatePageSize(pageSize);
            List<Tweet> tweets = tweetDao.getRecentTweets(contentSource, pageSize);
            filterAndEnrich(tweets);
            return tweets;
        } catch (Exception e) {
            TweetException te = new TweetException("Error while retrieving recent tweets for " + contentSource.getName(), e);
            logError(te);
            throw te;
        }
    }

    @Override
    public List<Tweet> getRecentTweets(Collection<ContentSource> contentSources, int page, int pageSize) {
        try {
            page = PageSize.validatePage(page);
            pageSize = PageSize.validatePageSize(pageSize);
            List<Tweet> tweets = tweetDao.getRecentTweets(contentSources, page, pageSize);
            filterAndEnrich(tweets);
            return tweets;
        } catch (Exception e) {
            TweetException te = new TweetException("Error while retrieving recent tweets for " + ContentSourceCollectionFormatter.format(contentSources), e);
            logError(te);
            throw te;
        }
    }

    @Override
    public long getNumberOfTweets(ContentSource contentSource, Date start, Date end) {
        try {
            return tweetDao.getNumberOfTweets(contentSource, start, end);
        } catch (Exception e) {
            TweetException te = new TweetException("Error while retrieving the number of tweets for " + contentSource.getName(), e);
            logError(te);
            throw te;
        }
    }

    @Override
    public long getNumberOfTweets() {
        try {
            return tweetDao.getNumberOfTweets();
        } catch (Exception e) {
            TweetException te = new TweetException("Error while retrieving the number of tweets", e);
            logError(te);
            throw te;
        }
    }

    @Override
    public long getNumberOfTweets(Collection<ContentSource> contentSources) {
        try {
            return tweetDao.getNumberOfTweets(contentSources);
        } catch (Exception e) {
            TweetException te = new TweetException("Error while retrieving the number of tweets for " + ContentSourceCollectionFormatter.format(contentSources), e);
            logError(te);
            throw te;
        }
    }

    @Override
    public void removeTweet(long tweetId) {
        try {
            tweetDao.removeTweet(tweetId);
        } catch (Exception e) {
            TweetException te = new TweetException("Error deleting tweet with ID " + tweetId, e);
            logError(te);
            throw te;
        }
    }

    @Override
    public void storeTweets(Collection<Tweet> tweets) {
        try {
            tweetDao.storeTweets(tweets);
        } catch (Exception e) {
            TweetException te = new TweetException("Error saving tweets", e);
            logError(te);
            throw te;
        }
    }

    private void filterAndEnrich(List<Tweet> tweets) {
        ContentItemFilter<Tweet> filter = new ContentItemFilter<>();
        filter.filter(tweets, contentSourceComponent, false);
    }

}
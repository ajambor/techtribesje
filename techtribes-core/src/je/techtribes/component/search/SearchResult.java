package je.techtribes.component.search;

import je.techtribes.domain.ContentItem;

public class SearchResult extends ContentItem {

    private String truncatedBody;
    private String permalink;
    private SearchResultType type;

    public SearchResult(SearchResultType type) {
        this.type = type;
    }

    @Override
    public String getBody() {
        return truncatedBody;
    }

    @Override
    public String getTruncatedBody() {
        return truncatedBody;
    }

    public void setTruncatedBody(String truncatedBody) {
        this.truncatedBody = truncatedBody;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public SearchResultType getType() {
        return type;
    }

    public boolean isNewsFeedEntry() {
        return this.type == SearchResultType.NewsFeedEntry;
    }

    public boolean isTweet() {
        return this.type == SearchResultType.Tweet;
    }

}

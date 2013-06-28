package je.techtribes.domain;

import java.net.URL;

public class NewsFeed {

    private URL url;
    private String title;
    private ContentSource contentSource;

    public NewsFeed(String url, ContentSource contentSource) throws Exception {
        this.url = new URL(url);
        this.contentSource = contentSource;
    }

    public URL getUrl() {
        return url;
    }

    public ContentSource getContentSource() {
        return contentSource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
package je.techtribes.web.controller;

import je.techtribes.component.contentsource.ContentSourceComponent;
import je.techtribes.component.newsfeedentry.NewsFeedEntryComponent;
import je.techtribes.domain.*;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractControllerTests {

    protected ContentSourceComponent createContentSourceComponent() {
        return new ContentSourceComponent() {
            @Override
            public void refreshContentSources() {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public List<ContentSource> getPeopleAndTribes() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public List<ContentSource> getContentSources(ContentSourceType type) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public List<Person> getPeople() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public List<Tribe> getTribes() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public ContentSource findById(int id) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public ContentSource findByShortName(String shortName) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public ContentSource findByTwitterId(String twitterId) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void add(ContentSource contentSource) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void update(ContentSource contentSource) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void updateTribeMembers(Tribe tribe, List<Integer> personIds) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void updateTribeMembershipsForPerson(Person person, List<Integer> tribeIds) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    protected NewsFeedEntryComponent createNewsFeedEntryComponent() {
        return new NewsFeedEntryComponent() {
            @Override
            public List<NewsFeedEntry> getRecentNewsFeedEntries(int page, int pageSize) {
                List<NewsFeedEntry> newsFeedEntries = new LinkedList<>();
                for (int i = 0; i < pageSize; i++) {
                    newsFeedEntries.add(new NewsFeedEntry("http://somedomain.com", "Title", "Body", new Date(), i));
                }
                return newsFeedEntries;
            }

            @Override
            public List<NewsFeedEntry> getRecentNewsFeedEntries(ContentSource contentSource, int pageSize) {
                return null;
            }

            @Override
            public List<NewsFeedEntry> getRecentNewsFeedEntries(Collection<ContentSource> contentSources, int page, int pageSize) {
                return null;
            }

            @Override
            public long getNumberOfNewsFeedEntries(ContentSource contentSource, Date start, Date end) {
                return 0;
            }

            @Override
            public long getNumberOfNewsFeedEntries() {
                return 0;
            }

            @Override
            public long getNumberOfNewsFeedEntries(Collection<ContentSource> contentSources) {
                return 0;
            }

            @Override
            public void storeNewsFeedEntries(Collection<NewsFeedEntry> newsFeedEntries) {
            }
        };
    }
}

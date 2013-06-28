package je.techtribes.component.contentsource;

import je.techtribes.domain.ContentSource;

import java.util.List;

interface ContentSourceDao {

    public List<ContentSource> loadContentSources();

    public void add(ContentSource contentSource);

    public void update(ContentSource contentSource);

    public void updateTribeMembers(ContentSource tribe, List<Integer> personIds);

    public void updateTribeMembershipsForPerson(ContentSource person, List<Integer> tribeIds);

}

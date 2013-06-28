package je.techtribes.component.activity;

import je.techtribes.domain.Activity;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

class ActivityResultExtractor implements ResultSetExtractor<Activity> {

    @Override
    public Activity extractData(ResultSet rs) throws SQLException {
        int contentSourceId = rs.getInt("content_source_id");
        int internationalTalks = rs.getInt("international_talks");
        int localTalks = rs.getInt("local_talks");
        int content = rs.getInt("content");
        int tweets = rs.getInt("tweets");
        int events = rs.getInt("events");
        Date lastActivityDate = rs.getTimestamp("last_activity_datetime");

        return new Activity(contentSourceId,
                internationalTalks,
                localTalks,
                content,
                tweets,
                events,
                lastActivityDate);
    }

}

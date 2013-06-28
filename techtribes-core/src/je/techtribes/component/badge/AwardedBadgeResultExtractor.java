package je.techtribes.component.badge;

import je.techtribes.domain.badge.AwardedBadge;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

class AwardedBadgeResultExtractor implements ResultSetExtractor<AwardedBadge> {

    @Override
    public AwardedBadge extractData(ResultSet rs) throws SQLException {
        int badgeId = rs.getInt("badge_id");
        int contentSourceId = rs.getInt("content_source_id");
        Date date = rs.getTimestamp("date");

        return new AwardedBadge(badgeId, contentSourceId, date);
    }

}

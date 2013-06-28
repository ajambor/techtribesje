package je.techtribes.component.badge;

import je.techtribes.domain.badge.AwardedBadge;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class AwardedBadgeRowMapper implements RowMapper<AwardedBadge> {

    @Override
    public AwardedBadge mapRow(ResultSet rs, int line) throws SQLException {
        AwardedBadgeResultExtractor extractor = new AwardedBadgeResultExtractor();
        return extractor.extractData(rs);
    }

}
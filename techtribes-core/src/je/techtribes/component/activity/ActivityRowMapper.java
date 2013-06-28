package je.techtribes.component.activity;

import je.techtribes.domain.Activity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class ActivityRowMapper implements RowMapper<Activity> {

    @Override
    public Activity mapRow(ResultSet rs, int line) throws SQLException {
        ActivityResultExtractor extractor = new ActivityResultExtractor();
        return extractor.extractData(rs);
    }

}
package je.techtribes.component.contentsource;

import je.techtribes.domain.ContentSource;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class ContentSourceRowMapper implements RowMapper<ContentSource> {

    @Override
    public ContentSource mapRow(ResultSet rs, int line) throws SQLException {
        ContentSourceResultExtractor extractor = new ContentSourceResultExtractor();
        return extractor.extractData(rs);
    }

}
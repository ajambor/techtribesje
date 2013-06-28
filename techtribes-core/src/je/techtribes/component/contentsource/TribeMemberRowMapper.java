package je.techtribes.component.contentsource;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class TribeMemberRowMapper implements RowMapper<TribeAndPersonLink> {

    @Override
    public TribeAndPersonLink mapRow(ResultSet rs, int line) throws SQLException {
        TribeMemberResultExtractor extractor = new TribeMemberResultExtractor();
        return extractor.extractData(rs);
    }

}
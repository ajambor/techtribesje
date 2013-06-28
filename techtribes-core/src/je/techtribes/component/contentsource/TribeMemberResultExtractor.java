package je.techtribes.component.contentsource;

import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

class TribeMemberResultExtractor implements ResultSetExtractor<TribeAndPersonLink> {

    @Override
    public TribeAndPersonLink extractData(ResultSet rs) throws SQLException {
        int tribeId = rs.getInt("tribe_id");
        int personId = rs.getInt("person_id");

        return new TribeAndPersonLink(tribeId, personId);
    }

}

package je.techtribes.component.contentsource;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

class JdbcUserConnectionDao implements UserConnectionDao {

    private DataSource dataSource;

    JdbcUserConnectionDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<String> getTwitterIds() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.queryForList("select userId from UserConnection where providerId = 'twitter'", String.class);
    }

}

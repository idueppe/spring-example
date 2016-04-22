package io.crowdcode.speedauction.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfiguration.class)
public class DataSourceConfigurationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testJdbcTemplate() throws Exception {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        String sql = "CREATE TABLE  ApplicationLog (\n" +
//                "  id BIGINT PRIMARY KEY NOT NULL,\n" +
//                "  message CHARACTER VARYING(255)\n" +
//                ");";
//        jdbcTemplate.execute(sql);

        String insert = "INSERT INTO ApplicationLog (id, message) VALUES (nextval('logsequence'), :message)";

        jdbcTemplate.update(insert, new MapSqlParameterSource("message", "HelloAgain"));


        String select = "SELECT message FROM ApplicationLog WHERE id=:id";
        MapSqlParameterSource parameters = new MapSqlParameterSource("id", 1l);
        String result = jdbcTemplate.queryForObject(select, parameters, String.class);
        System.out.println(result);

        List<String> msgs = jdbcTemplate.query("SELECT id, message FROM ApplicationLog", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("message");
            }
        });

        msgs.forEach(System.out::println);

    }


}
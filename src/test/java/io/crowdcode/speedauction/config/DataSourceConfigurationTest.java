package io.crowdcode.speedauction.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabasePopulateConfiguration.class})
public class DataSourceConfigurationTest {

    private static final String INSERT_ONE = "INSERT INTO ApplicationLog (id, message) VALUES (nextval('logsequence'), :message)";
    private static final String SELECT_ONE = "SELECT message FROM ApplicationLog WHERE id=:id";
    private static final String SELECT_ALL = "SELECT message FROM ApplicationLog";

    @Autowired
    private DataSource dataSource;

    @Test
    public void testJdbcTemplate() throws Exception {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        jdbcTemplate.update(INSERT_ONE, new MapSqlParameterSource("message", "Hello1"));
        jdbcTemplate.update(INSERT_ONE, new MapSqlParameterSource("message", "Hello2"));

        MapSqlParameterSource parameters = new MapSqlParameterSource("id", 1l);
        String result = jdbcTemplate.queryForObject(SELECT_ONE, parameters, String.class);
        assertThat(result, is("Hello1"));

        List<String> msgs = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> {
            return rs.getString("message");
        });

        msgs.forEach(System.out::println);

        List<String> messages = jdbcTemplate.queryForList(SELECT_ALL, new MapSqlParameterSource(), String.class);
        messages.forEach(System.out::println);
    }
}
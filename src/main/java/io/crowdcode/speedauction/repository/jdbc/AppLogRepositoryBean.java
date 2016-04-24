package io.crowdcode.speedauction.repository.jdbc;

import io.crowdcode.speedauction.model.Message;
import io.crowdcode.speedauction.repository.AppLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Repository
public class AppLogRepositoryBean extends NamedParameterJdbcDaoSupport implements AppLogRepository {

    public static final String INSERT_SQL = "INSERT INTO AppLog (id, message, createdAt, createdBy) VALUES (nextVal('AppLogSequence'), :message, :createdAt, :createdBy)";
    public static final String SELECT_BETWEEN_SQL = "SELECT id, message, createdAt, createdBy FROM AppLog WHERE createdAt BETWEEN :from and :to";

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void init() {
        setDataSource(dataSource);
    }

    @Override
    public void log(String message, LocalDateTime createdAt, String createdBy) {
        getNamedParameterJdbcTemplate().update(INSERT_SQL,
                new MapSqlParameterSource()
                        .addValue("message", message)
                        .addValue("createdAt", Timestamp.valueOf(createdAt))
                        .addValue("createdBy", createdBy));
    }

    @Override
    public List<Message> findLogs(LocalDateTime from, LocalDateTime to) {
        return getNamedParameterJdbcTemplate().query(SELECT_BETWEEN_SQL,
                new MapSqlParameterSource()
                        .addValue("from", Timestamp.valueOf(from))
                        .addValue("to", Timestamp.valueOf(to)),
                (rs, rowNum) -> new Message()
                        .withMessage(rs.getString("message"))
                        .withCreatedBy(rs.getString("createdBy"))
                        .withCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime()));
    }

}
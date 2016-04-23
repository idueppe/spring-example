package io.crowdcode.speedauction.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import(DataSourceConfiguration.class)
public class DatabasePopulateConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DatabasePopulateConfiguration.class);

    private static final String APPLICATIONLOG_SQL = "application_log_schema.sql";

    @Bean
    public DatabasePopulator databasePopulator(DataSource dataSource) {
        log.info(" Populating Database ");

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(true);
        populator.addScript(new ClassPathResource(APPLICATIONLOG_SQL));
        try {
            populator.populate(dataSource.getConnection());
        } catch (SQLException e) {
            log.error("Exception Populating Database", e);
        }
        return populator;
    }

}

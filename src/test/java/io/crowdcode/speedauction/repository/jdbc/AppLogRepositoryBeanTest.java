package io.crowdcode.speedauction.repository.jdbc;

import io.crowdcode.speedauction.config.AppLogConfiguration;
import io.crowdcode.speedauction.config.JdbcTransactionConfiguration;
import io.crowdcode.speedauction.model.Message;
import io.crowdcode.speedauction.repository.AppLogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppLogConfiguration.class, JdbcTransactionConfiguration.class})
public class AppLogRepositoryBeanTest {

    @Autowired
    private AppLogRepository logRepository;

    @Test
    public void testLog() throws Exception {
        logRepository.log("UNITTEST", LocalDateTime.now(), "UNITTEST");

        List<Message> logs = logRepository.findLogs(LocalDateTime.now().minus(10, ChronoUnit.SECONDS), LocalDateTime.now());

        assertThat(logs, contains(hasProperty("message", is("UNITTEST"))));
    }
}
package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.config.LayerConfiguration;
import io.crowdcode.speedauction.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Duration;
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
@ContextConfiguration(classes = LayerConfiguration.class)
public class ApplicationLogServiceBeanTest {

    @Autowired
    private ApplicationLogService applicationLogService;

    @Test
    public void testApplicationLogging() throws Exception {
        applicationLogService.log("JUNIT TEST %s", "LOG");
        List<Message> messages = applicationLogService
                .lastLogs(Duration.of(5, ChronoUnit.SECONDS));

        messages.forEach(System.out::println);

        assertThat(messages, contains(hasProperty("message", is("JUNIT TEST LOG"))));
    }
}
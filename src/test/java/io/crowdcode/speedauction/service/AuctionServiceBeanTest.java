package io.crowdcode.speedauction.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.datetime.joda.LocalDateParser;

import java.time.LocalDateTime;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionServiceBeanTest {

    private static final Logger log = LoggerFactory.getLogger(AuctionServiceBeanTest.class);

    @Test
    public void testApplicationContext() throws Exception {
        log.info("======== Starting Test at {} ", LocalDateTime.now().toLocalTime().toString());

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("uebung-1.xml")) {
            AuctionService bean = context.getBean("auctionService", AuctionService.class);

            assertTrue(context.isSingleton("auctionService"));

            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

            assertNotNull(bean);
        }



    }
}
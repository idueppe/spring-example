package io.crowdcode.speedauction.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionServiceBeanTest {

    @Test
    public void testApplicationContext() throws Exception {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("uebung-1.xml")) {
            AuctionService bean = context.getBean("auctionService", AuctionService.class);
            assertNotNull(bean);
        }
    }
}
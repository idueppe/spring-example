package io.crowdcode.speedauction;

import io.crowdcode.speedauction.service.AuctionService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class Uebung_1_XmlTest {

    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:/uebung-1.xml");
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void testApplicationContext() throws Exception {
        AuctionService bean = context.getBean("auctionService", AuctionService.class);
        assertNotNull(bean);
    }

    @Test
    public void testListingBeans() throws Exception {
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

    }
}


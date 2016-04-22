package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.repository.AuctionRepository;
import io.crowdcode.speedauction.repository.inmemory.InMemoryStore;
import io.crowdcode.speedauction.service.AuctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BusinessLogicAnnotationConfiguration.class)
public class BusinessLogicAnnotationConfigurationTest {

    @Autowired
    private InMemoryStore inMemoryStore;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testThatBeansExists() throws Exception {
        assertNotNull(inMemoryStore);
        assertNotNull(auctionService);
        assertNotNull(auctionRepository);
    }

    @Test
    public void testThatOtherConfigurationNotLoaded() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("| " + beanName);
        }
        assertFalse(Arrays.toString(beanNames).contains("businessLogicConfiguration"));
    }

}
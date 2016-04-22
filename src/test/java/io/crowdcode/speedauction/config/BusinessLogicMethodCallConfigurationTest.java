package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.repository.inmemory.AuctionRepositoryInMemoryBean;
import io.crowdcode.speedauction.repository.inmemory.InMemoryStore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertFalse;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class BusinessLogicMethodCallConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(BusinessLogicMethodCallConfiguration.class);
    }

    @Test
    public void testInnerBean() throws Exception {
        AuctionRepositoryInMemoryBean auctionRepository = context.getBean("auctionRepository", AuctionRepositoryInMemoryBean.class);
        InMemoryStore inMemoryStore = context.getBean("inMemoryStore", InMemoryStore.class);
        assertFalse(auctionRepository.getStore() == inMemoryStore);
    }

    @Test
    public void testInnerBean2() throws Exception {
        AuctionRepositoryInMemoryBean auctionRepository = context.getBean("auctionRepository", AuctionRepositoryInMemoryBean.class);
        InMemoryStore inMemoryStore = context.getBean("inMemoryStore", InMemoryStore.class);
        assertFalse(auctionRepository.getStore() == inMemoryStore);
    }
}
package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.repository.AuctionRepository;
import io.crowdcode.speedauction.repository.inmemory.InMemoryStore;
import io.crowdcode.speedauction.service.AuctionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BusinessLogicNamedConfiguration.class)
public class BusinessLogicNamedConfigurationTest {

    @Autowired
    private InMemoryStore inMemoryStore;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionRepository auctionRepository;

    @Test
    public void testConfigTest() throws Exception {
        assertNotNull(inMemoryStore);
        assertNotNull(auctionService);
        assertNotNull(auctionRepository);
    }
}
package io.crowdcode.speedauction.repository;

import io.crowdcode.speedauction.config.BusinessLogicAnnotationConfiguration;
import io.crowdcode.speedauction.config.JpaPersistenceContextConfiguration;
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
@ContextConfiguration(classes = {BusinessLogicAnnotationConfiguration.class, JpaPersistenceContextConfiguration.class})
public class AuctionRepositoryNoProfileTest {

    @Autowired
    private AuctionRepository auctionRepository;

    @Test
    public void testThatInMemoryRepositoryIsUsed() throws Exception {
        assertNotNull(auctionRepository);

    }
}

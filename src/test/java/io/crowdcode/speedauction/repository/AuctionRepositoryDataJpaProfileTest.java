package io.crowdcode.speedauction.repository;

import io.crowdcode.speedauction.config.BusinessLogicAnnotationConfiguration;
import io.crowdcode.speedauction.config.DataJpaRepositoryConfiguration;
import io.crowdcode.speedauction.config.JpaPersistenceContextConfiguration;
import io.crowdcode.speedauction.repository.datajpa.AuctionRepositoryDataJpa;
import io.crowdcode.speedauction.repository.jpa.AuctionRepositoryJpaBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BusinessLogicAnnotationConfiguration.class, DataJpaRepositoryConfiguration.class})
@ActiveProfiles("datajpa")
public class AuctionRepositoryDataJpaProfileTest {

    @Autowired
    private AuctionRepository auctionRepository;

    @Test
    public void testThatJpaRepositoryIsUsed() throws Exception {
        assertNotNull(auctionRepository);
    }

}

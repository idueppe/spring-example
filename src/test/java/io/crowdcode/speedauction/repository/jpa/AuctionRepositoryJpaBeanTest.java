package io.crowdcode.speedauction.repository.jpa;

import io.crowdcode.speedauction.config.BusinessLogicAnnotationConfiguration;
import io.crowdcode.speedauction.config.JpaPersistenceContextConfiguration;
import io.crowdcode.speedauction.fixture.AuctionFixture;
import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.repository.AuctionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BusinessLogicAnnotationConfiguration.class, JpaPersistenceContextConfiguration.class})
@ActiveProfiles("jpa")
@Transactional
public class AuctionRepositoryJpaBeanTest {

    private final AuctionFixture auctionFixture = new AuctionFixture();
    @Autowired
    private AuctionRepository auctionRepository;

    @Test
    public void testAuctionCreate() throws Exception {
        Auction auction = auctionFixture.buildDefaultAuction();
        auctionRepository.save(auction);
        assertNotNull(auction.getId());
    }

}
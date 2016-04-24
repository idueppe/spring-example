package io.crowdcode.speedauction.repository.datajpa;

import io.crowdcode.speedauction.config.BusinessLogicAnnotationConfiguration;
import io.crowdcode.speedauction.config.DataJpaRepositoryConfiguration;
import io.crowdcode.speedauction.fixture.AuctionFixture;
import io.crowdcode.speedauction.model.Auction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BusinessLogicAnnotationConfiguration.class, DataJpaRepositoryConfiguration.class})
@Transactional
@ActiveProfiles("datajpa")
public class AuctionRepositoryDataJpaTest {

    @Autowired
    private AuctionRepositoryDataJpa repository;

    @Test
    public void testAuctionRepository() throws Exception {
        repository.save(AuctionFixture.buildDefaultAuction());
        List<Auction> auctions = repository.allAuctionWithABidFrom("unit@test.org");
        auctions.forEach(System.out::println);

        assertFalse(auctions.isEmpty());
    }
}
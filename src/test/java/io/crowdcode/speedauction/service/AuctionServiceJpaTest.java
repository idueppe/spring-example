package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.config.BusinessLogicAnnotationConfiguration;
import io.crowdcode.speedauction.config.JpaPersistenceContextConfiguration;
import io.crowdcode.speedauction.fixture.AuctionFixture;
import io.crowdcode.speedauction.model.Auction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BusinessLogicAnnotationConfiguration.class, JpaPersistenceContextConfiguration.class})
@ActiveProfiles("jpa")
@Transactional
public class AuctionServiceJpaTest {

    @Autowired
    private AuctionService auctionService;

    @Test
    public void testAuctionCreate() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime until = LocalDateTime.now().plus(1, ChronoUnit.MINUTES);
        Long auctionId = auctionService.placeAuction(AuctionFixture.buildProductDetail(), start, until);

        Auction auction = auctionService.findAuction(auctionId);
        assertThat(auction.getProduct().getTitle(), is("MacBook Pro"));
    }


}
package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.config.AppLogConfiguration;
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

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataJpaRepositoryConfiguration.class,
        AppLogConfiguration.class,
        BusinessLogicAnnotationConfiguration.class})
@ActiveProfiles("datajpa")
@Transactional
public class AuctionServiceWithDataJpaTest {

    @Autowired
    private AuctionService auctionService;

    @Test
    public void testPlaceAuction() throws Exception {
        Long auctionId = auctionService.placeAuction(
                AuctionFixture.buildProductDetail(),
                LocalDateTime.now(),
                LocalDateTime.now().plus(1, ChronoUnit.MINUTES));

        Auction auction = auctionService.findAuction(auctionId);
        assertNotNull(auction.getId());
        assertNotNull(auction.getProduct());
        assertNotNull(auction.getProduct().getId());

    }
}
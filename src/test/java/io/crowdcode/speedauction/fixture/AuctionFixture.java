package io.crowdcode.speedauction.fixture;

import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.model.Bid;
import io.crowdcode.speedauction.model.ProductDetail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * @author Ingo Dueppe (Crowdcode)
 */
public class AuctionFixture {

    public static Auction buildDefaultAuction() {
        return new Auction()
                .withBeginDate(LocalDateTime.now())
                .withExpireDate(LocalDateTime.now().plus(2, ChronoUnit.MINUTES))
                .withOwner("unittest")
                .withProduct(
                        new ProductDetail()
                                .withTitle("MacBook Pro")
                                .withMinAmount(BigDecimal.ONE)
                                .withDescription("MacBook Pro 15\" Retina"))
                .withBids(Arrays.asList(
                        new Bid()
                                .withAmount(BigDecimal.ONE)
                                .withEmail("unit@test.org"),
                        new Bid()
                                .withAmount(BigDecimal.TEN)
                                .withEmail("test@unit.org"))
                );
    }
}
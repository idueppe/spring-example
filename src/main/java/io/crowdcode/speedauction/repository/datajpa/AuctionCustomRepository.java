package io.crowdcode.speedauction.repository.datajpa;

import io.crowdcode.speedauction.model.Auction;

import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface AuctionCustomRepository {

    List<Auction> allAuctionWithABidFrom(String email);

}

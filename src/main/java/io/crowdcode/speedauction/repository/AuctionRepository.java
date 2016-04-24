package io.crowdcode.speedauction.repository;

import io.crowdcode.speedauction.model.Auction;

import java.util.List;
import java.util.Optional;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface AuctionRepository {

    Optional<Auction> find(Long auctionId);

    List<Auction> findAll();

    Auction save(Auction auction);

}

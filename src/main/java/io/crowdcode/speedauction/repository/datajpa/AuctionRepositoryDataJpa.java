package io.crowdcode.speedauction.repository.datajpa;

/**
 * @author Ingo Düppe (Crowdcode)
 */

import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.repository.AuctionRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile({"datajpa"})
public interface AuctionRepositoryDataJpa extends AuctionRepositoryDefaultDataJpa, AuctionRepository, AuctionCustomRepository {

    @Query("SELECT a FROM Auction a WHERE a.id = :id")
    Optional<Auction> find(@Param("id") Long auctionId);

    List<Auction> findAll();

    Auction save(Auction auction);


}

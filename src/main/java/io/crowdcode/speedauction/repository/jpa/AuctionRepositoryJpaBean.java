package io.crowdcode.speedauction.repository.jpa;

import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.repository.AuctionRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Repository
@Profile("jpa")
public class AuctionRepositoryJpaBean implements AuctionRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Optional<Auction> find(Long auctionId) {
        return Optional.ofNullable(em.find(Auction.class, auctionId));
    }

    @Override
    public List<Auction> findAll() {
        return em.createQuery("SELECT a FROM Auction a", Auction.class).getResultList();
    }

    @Override
    public void save(Auction auction) {
        em.persist(auction);
    }
}

package io.crowdcode.speedauction.repository.datajpa;

import io.crowdcode.speedauction.model.Auction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */

public class AuctionRepositoryDataJpaImpl implements AuctionCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Auction> allAuctionWithABidFrom(String email) {
        final String jql = "SELECT a FROM Auction a LEFT JOIN a.bids b WHERE b.email = :email";
        return em.createQuery(jql, Auction.class)
                .setParameter("email", email)
                .getResultList();
    }
}

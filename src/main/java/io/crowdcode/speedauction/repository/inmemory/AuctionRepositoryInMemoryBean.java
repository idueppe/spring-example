package io.crowdcode.speedauction.repository.inmemory;

import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Repository
public class AuctionRepositoryInMemoryBean implements AuctionRepository {

    @Autowired
    private InMemoryStore<Auction> store;

    @Override
    public Optional<Auction> find(Long auctionId) {
        return Optional.ofNullable(store.load(auctionId));
    }

    @Override
    public List<Auction> findAll() {
        return store.loadAll();
    }

    @Override
    public void save(Auction auction) {
        store.save(auction);
    }

    public void setStore(InMemoryStore<Auction> store) {
        this.store = store;
    }
}

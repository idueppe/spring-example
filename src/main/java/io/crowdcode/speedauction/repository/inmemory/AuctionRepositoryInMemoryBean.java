package io.crowdcode.speedauction.repository.inmemory;

import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.repository.AuctionRepository;
import io.crowdcode.speedauction.util.DefaultInMemoryProfileCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Repository
@Conditional(DefaultInMemoryProfileCondition.class)
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
    public Auction save(Auction auction) {
        store.save(auction);
        return auction;
    }

    @Override
    public Page<Auction> findAll(Pageable pageable) {
        return new PageImpl<>(findAll());
    }

    public InMemoryStore<Auction> getStore() {
        return store;
    }

    public void setStore(InMemoryStore<Auction> store) {
        this.store = store;
    }
}

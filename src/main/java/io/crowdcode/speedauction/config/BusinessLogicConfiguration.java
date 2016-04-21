package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.model.ProductDetail;
import io.crowdcode.speedauction.repository.AuctionRepository;
import io.crowdcode.speedauction.repository.inmemory.AuctionRepositoryInMemoryBean;
import io.crowdcode.speedauction.repository.inmemory.InMemoryStore;
import io.crowdcode.speedauction.service.AuctionService;
import io.crowdcode.speedauction.service.AuctionServiceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
public class BusinessLogicConfiguration {

    @Bean
    public AuctionService auctionService(AuctionRepository auctionRepository) {
        AuctionServiceBean auctionService = new AuctionServiceBean();
        auctionService.setAuctionRepository(auctionRepository);
        return auctionService;
    }

    @Bean
    public AuctionRepository auctionRepository(InMemoryStore<Auction> inMemoryStore) {
        AuctionRepositoryInMemoryBean repository = new AuctionRepositoryInMemoryBean();
        repository.setStore(inMemoryStore);
        return repository;
    }

    @Bean()
    public InMemoryStore<Auction> inMemoryStore() {
        return new InMemoryStore<>();
    }

    @Bean()
    public InMemoryStore<ProductDetail> inMemoryStoreProduct() {
        return new InMemoryStore<>();
    }

}

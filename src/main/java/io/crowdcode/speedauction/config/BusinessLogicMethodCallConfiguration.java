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
import org.springframework.context.annotation.Scope;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
public class BusinessLogicMethodCallConfiguration {

    @Bean
    public AuctionService auctionService() {
        AuctionServiceBean auctionService = new AuctionServiceBean();
        auctionService.setAuctionRepository(auctionRepository());

        InMemoryStore<Auction> storeA = inMemoryStore();
        InMemoryStore<Auction> storeB = inMemoryStore();

        System.out.println(storeA == storeB);

        return auctionService;
    }

    @Bean
    public AuctionRepository auctionRepository() {
        AuctionRepositoryInMemoryBean repository = new AuctionRepositoryInMemoryBean();
        repository.setStore(inMemoryStore());
        return repository;
    }

    @Bean
    public InMemoryStore<Auction> inMemoryStore() {
        return new InMemoryStore<>();
    }

    @Bean
//    @Scope(value = "prototype")
    public InMemoryStore<ProductDetail> inMemoryStoreProduct() {
        return new InMemoryStore<>();
    }

}

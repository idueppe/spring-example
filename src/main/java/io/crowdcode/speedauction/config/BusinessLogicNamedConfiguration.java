package io.crowdcode.speedauction.config;


import io.crowdcode.speedauction.commons.Identifiable;
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
public class BusinessLogicNamedConfiguration {

    @Bean(name = "inMemoryStore", initMethod = "init")
    public <T extends Identifiable<Long>> InMemoryStore<T> inMemoryStore() {
        return new InMemoryStore();
    }

    @Bean(name = "auctionRepository")
    public AuctionRepository auctionRepository(InMemoryStore inMemoryStore) {
        AuctionRepositoryInMemoryBean repositoryBean = new AuctionRepositoryInMemoryBean();
        repositoryBean.setStore(inMemoryStore);
        return repositoryBean;
    }

    @Bean(name = "productRepository")
    public AuctionRepository productRepository(InMemoryStore inMemoryStore) {
        AuctionRepositoryInMemoryBean repositoryBean = new AuctionRepositoryInMemoryBean();
        repositoryBean.setStore(inMemoryStore);
        return repositoryBean;
    }

    @Bean(name = "speedAuctionService")
    public AuctionService speedAuctionService(
            AuctionRepository auctionRepository) {
        AuctionServiceBean serviceBean = new AuctionServiceBean();
        serviceBean.setAuctionRepository(auctionRepository);
        return serviceBean;
    }
}

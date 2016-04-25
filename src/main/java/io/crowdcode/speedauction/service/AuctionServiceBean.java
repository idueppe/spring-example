package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.exception.AuctionNotFoundException;
import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.model.ProductDetail;
import io.crowdcode.speedauction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Component
public class AuctionServiceBean implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public Long placeAuction(ProductDetail details, LocalDateTime startTime, LocalDateTime expireDateTime) {
        Auction auction = new Auction()
                .withOwner("anonymous")
                .withBeginDate(startTime)
                .withExpireDate(expireDateTime)
                .withProduct(new ProductDetail()
                        .withTitle(details.getTitle())
                        .withMinAmount(details.getMinAmount())
                        .withDescription(details.getDescription()));
        auctionRepository.save(auction);
        return auction.getId();
    }

    @Override
    public List<Auction> findAllRunning() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction findAuction(Long auctionId) throws AuctionNotFoundException {
        return auctionRepository
                .find(auctionId)
                .orElseThrow(() -> new AuctionNotFoundException(auctionId));
    }

    @Override
    public Page<Auction> findAll(Pageable pageable) {
        return auctionRepository.findAll(pageable);
    }

    public void setAuctionRepository(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

}

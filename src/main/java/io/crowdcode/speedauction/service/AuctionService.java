package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.exception.AuctionNotFoundException;
import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.model.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface AuctionService {

    Long placeAuction(ProductDetail productDetail, LocalDateTime startTime, LocalDateTime expireDateTime);

    List<Auction> findAllRunning();

    Auction findAuction(Long auctionId) throws AuctionNotFoundException;

    Page<Auction> findAll(Pageable pageable);
}

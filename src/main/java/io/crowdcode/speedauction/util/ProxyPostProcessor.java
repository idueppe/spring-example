package io.crowdcode.speedauction.util;

import io.crowdcode.speedauction.commons.Identifiable;
import io.crowdcode.speedauction.exception.AuctionNotFoundException;
import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.model.ProductDetail;
import io.crowdcode.speedauction.service.AuctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

import static io.crowdcode.speedauction.commons.AnsiColor.blue;
import static io.crowdcode.speedauction.commons.AnsiColor.green;
import static io.crowdcode.speedauction.commons.AnsiColor.red;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class ProxyPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(ProxyPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info(green("Got Bean {} before."), beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info(blue("Got Bean {} after."), beanName);

        if (bean instanceof AuctionService) {
            return new ProxyAuctionService((AuctionService) bean);

        } else {
            return bean;
        }
    }

    public static class ProxyAuctionService implements AuctionService, Identifiable<Long> {

        private AuctionService target;

        private List<Auction> cache;

        public ProxyAuctionService(AuctionService target) {
            this.target = target;
        }

        @Override
        public Long placeAuction(ProductDetail productDetail, LocalDateTime startTime, LocalDateTime expireDateTime) {
            return target.placeAuction(productDetail, startTime, expireDateTime);
        }

        @Override
        public List<Auction> findAllRunning() {
            // Fachlich äußerst bedenklich :-)
            log.info(red("FindAllRunning called"));
            if (cache == null) {
                cache = target.findAllRunning();
            }
            return cache;
        }

        @Override
        public Auction findAuction(Long auctionId) throws AuctionNotFoundException {
            return target.findAuction(auctionId);
        }

        @Override
        public Page<Auction> findAll(Pageable pageable) {
            return target.findAll(pageable);
        }

        @Override
        public Long getId() {
            return System.currentTimeMillis();
        }

        @Override
        public void setId(Long aLong) {

        }
    }
}

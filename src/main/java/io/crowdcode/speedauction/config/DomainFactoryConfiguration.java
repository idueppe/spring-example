package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.model.Bid;
import io.crowdcode.speedauction.model.DomainFactory;
import io.crowdcode.speedauction.model.ProductDetail;
import io.crowdcode.speedauction.util.LoggingPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import(BusinessLogicAnnotationConfiguration.class)
public class DomainFactoryConfiguration {

    @Bean
    @Scope("prototype")
    public static ProductDetail product() {
        return new ProductDetail().withMinAmount(BigDecimal.TEN);
    }

    @Bean
    @Scope("prototype")
    public static Auction auction() {
        return new Auction()
                .withOwner("Me")
                .withBeginDate(LocalDateTime.now().plus(1, ChronoUnit.MINUTES))
                .withExpireDate(LocalDateTime.now().plus(2, ChronoUnit.MINUTES));
    }

    @Bean
    @Scope("prototype")
    public static Bid bid() {
        return new Bid()
                .withEmail("bid@der.com")
                .withAmount(BigDecimal.ONE);
    }

    @Bean
    public DomainFactory domainFactory() {
        return new DomainFactory();
    }

}

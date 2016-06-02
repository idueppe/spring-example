package io.crowdcode.speedauction.service;

import io.crowdcode.speedauction.config.AppLogConfiguration;
import io.crowdcode.speedauction.config.BusinessLogicAnnotationConfiguration;
import io.crowdcode.speedauction.config.JdbcTransactionConfiguration;
import io.crowdcode.speedauction.model.Message;
import io.crowdcode.speedauction.model.ProductDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        AppLogConfiguration.class,
        JdbcTransactionConfiguration.class,
        BusinessLogicAnnotationConfiguration.class
})
public class AppLogAdviceTest {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    @Lazy
    private AppLogService appLogService;

    @Test
    @Sql(statements = "DELETE FROM AppLog")
    public void testAppLogConfiguration() throws Exception {
        ProductDetail productDetail = new ProductDetail()
                .withTitle("MacBook Pro")
                .withDescription("MacBook Pro 15\" Retina (Late 2012)")
                .withMinAmount(BigDecimal.TEN);
        auctionService.placeAuction(productDetail, LocalDateTime.now(), LocalDateTime.MAX);

        List<Message> messages = appLogService.lastLogs(Duration.of(10, ChronoUnit.SECONDS));
        messages.forEach(System.out::println);

        assertThat(messages.isEmpty(), is(false));
    }
}
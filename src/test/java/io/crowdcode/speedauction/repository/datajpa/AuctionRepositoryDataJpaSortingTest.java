package io.crowdcode.speedauction.repository.datajpa;

import io.crowdcode.speedauction.config.BusinessLogicAnnotationConfiguration;
import io.crowdcode.speedauction.config.DataJpaRepositoryConfiguration;
import io.crowdcode.speedauction.model.Auction;
import io.crowdcode.speedauction.model.Bid;
import io.crowdcode.speedauction.model.ProductDetail;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BusinessLogicAnnotationConfiguration.class, DataJpaRepositoryConfiguration.class})
@Transactional
@ActiveProfiles("datajpa")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuctionRepositoryDataJpaSortingTest {

	@Autowired
	private AuctionRepositoryDataJpa repository;

	@Test
	public void testFindAllSorting() throws Exception {
		persistTestData();

		Sort sort = new Sort(Sort.Direction.DESC, "product.title");

		List<Auction> auctions = repository.findAll(sort);
		auctions.forEach(System.out::println);
	}

	@Test
	public void testFindAllMultipleSorting() throws Exception {
		persistTestData();

		Sort sort = new Sort(
                new Sort.Order(Sort.Direction.ASC, "product.title"),
                new Sort.Order(Sort.Direction.DESC, "bids.amount"));

        List<Auction> auctions = repository.findAll(sort);
        auctions.forEach(System.out::println);
	}

	private void persistTestData() {
		repository.save(createTestAuction("A", 3));
		repository.save(createTestAuction("B", 2));
		repository.save(createTestAuction("C", 1));
	}

    public static Auction createTestAuction(String title, int amount) {
        return new Auction()
                .withExpireDate(LocalDateTime.now().plus(1, ChronoUnit.HOURS))
                .withProduct(
                        new ProductDetail().withDescription("description")
                                .withMinAmount(BigDecimal.ONE)
                                .withTitle(title))
                .withBids(Arrays.asList(
                        new Bid()
                                .withAmount(BigDecimal.valueOf(amount))
                                .withEmail("kontakt@crowdcode.io")));
    }


}
package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.model.DomainFactory;
import io.crowdcode.speedauction.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DomainFactoryConfiguration.class)
public class DomainFactoryConfigurationTest {

    @Autowired
    private DomainFactory domainFactory;

    @Test
    public void testDomainFactory() throws Exception {
        Product one = domainFactory.createProduct();
        Product two = domainFactory.createProduct();

        assertFalse(one == two);
        assertEquals(one.getMinAmount(), BigDecimal.TEN);

    }
}
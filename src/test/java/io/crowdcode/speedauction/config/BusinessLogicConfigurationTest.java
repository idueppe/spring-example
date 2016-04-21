package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.service.AuctionService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class BusinessLogicConfigurationTest {

    @Test
    public void testModelConfiguration() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BusinessLogicConfiguration.class);

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("> " + name);
            System.out.println(Arrays.toString(context.getAliases(name)));
        }

        AuctionService service = context.getBean("auctionService", AuctionService.class);
        service.findAllRunning();

        context.close();
    }
}
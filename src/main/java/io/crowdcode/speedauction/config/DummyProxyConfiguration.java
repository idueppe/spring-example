package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.util.ProxyPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import(BusinessLogicAnnotationConfiguration.class)
public class DummyProxyConfiguration {

    @Bean
    public static ProxyPostProcessor proxyPostProcessor() {
        return new ProxyPostProcessor();
    }

}

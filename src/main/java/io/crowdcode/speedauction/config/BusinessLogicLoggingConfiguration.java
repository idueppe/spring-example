package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.util.LoggingPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import(BusinessLogicAnnotationConfiguration.class)
@ImportResource()
public class BusinessLogicLoggingConfiguration {

    @Bean()
    public static LoggingPostProcessor postProcessor() {
        return new LoggingPostProcessor();
    }

}

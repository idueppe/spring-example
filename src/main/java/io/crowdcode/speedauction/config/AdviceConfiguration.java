package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.util.LoggingAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import(BusinessLogicAnnotationConfiguration.class)
@EnableAspectJAutoProxy
public class AdviceConfiguration {


    @Bean
    public static LoggingAdvice loggingAdvice() {
        return new LoggingAdvice();
    }


}

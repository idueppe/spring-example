package io.crowdcode.speedauction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@ComponentScan(
        basePackages = "io.crowdcode.speedauction",
        excludeFilters =
                {
                        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "io\\.crowdcode\\.speedauction\\.config.*"),
                        @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*AppLog.*")
                })
public class BusinessLogicAnnotationConfiguration {

}

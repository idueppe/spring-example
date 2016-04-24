package io.crowdcode.speedauction.config;

import io.crowdcode.speedauction.repository.AppLogRepository;
import io.crowdcode.speedauction.repository.jdbc.AppLogRepositoryBean;
import io.crowdcode.speedauction.service.AppLogServiceBean;
import io.crowdcode.speedauction.service.AppLogAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import({DatabasePopulateConfiguration.class})
@EnableAspectJAutoProxy
public class AppLogConfiguration {

    @Bean
    public AppLogAdvice appLogAdvice() {
        return new AppLogAdvice();
    }

    @Bean
    public AppLogRepository appLogRepositoryBean() {
        return new AppLogRepositoryBean();
    }

    @Bean
    public AppLogServiceBean appLogServiceBean() {
        return new AppLogServiceBean();
    }

}

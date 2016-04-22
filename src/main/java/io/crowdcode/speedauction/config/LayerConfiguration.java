package io.crowdcode.speedauction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import({BusinessLogicAnnotationConfiguration.class, DataSourceConfiguration.class})
public class LayerConfiguration {
}

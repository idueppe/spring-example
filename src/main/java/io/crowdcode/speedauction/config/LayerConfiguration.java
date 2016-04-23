package io.crowdcode.speedauction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import({BusinessLogicAnnotationConfiguration.class, DatabasePopulateConfiguration.class})
public class LayerConfiguration {
}
package io.crowdcode.speedauction.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import static io.crowdcode.speedauction.commons.AnsiColor.blue;
import static io.crowdcode.speedauction.commons.AnsiColor.green;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class LoggingPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(LoggingPostProcessor.class);


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info(green("Bean {} is before Initialization."), beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info(blue("Bean {} is after Initialization."), beanName);
        return bean;
    }
}

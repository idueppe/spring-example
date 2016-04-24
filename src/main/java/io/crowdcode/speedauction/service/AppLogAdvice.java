package io.crowdcode.speedauction.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import static io.crowdcode.speedauction.commons.AnsiColor.green;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Aspect
public class AppLogAdvice {

    private static final Logger log = LoggerFactory.getLogger(AppLogAdvice.class);

    @Autowired
    @Lazy
    private AppLogService appLogService;

    @Around("execution(* io.crowdcode.speedauction.service.AuctionServiceBean.*(..))")
    public Object basicLogging(ProceedingJoinPoint pjp) throws Throwable {
        appLogService.log(pjp.getSignature().getName());
        log.info(green("starting method {}"), pjp.toString());
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }
}

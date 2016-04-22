package io.crowdcode.speedauction.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.crowdcode.speedauction.commons.AnsiColor.green;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Aspect
public class LoggingAdvice {

    private static final Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

    @Around("execution(* io.crowdcode.speedauction.*.*.*(..))")
    public Object basicLogging(ProceedingJoinPoint pjp) throws Throwable {
        log.info(green("starting method {}"), pjp.toString());
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }

}

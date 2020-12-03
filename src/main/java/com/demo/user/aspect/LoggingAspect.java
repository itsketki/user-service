package com.demo.user.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* <h1>Logging Aspect</h1>
* The class is the logging aspect for centralised logging implementation.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/

@Component
@Aspect
public class LoggingAspect {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Before("within(com.demo.user..*)")
    public void loggingBeforeAdvice(JoinPoint joinPoint)  throws Throwable{
        LOGGER.info("{} has started execution.", joinPoint.getSignature());
    }

    @After("within(com.demo.user..*)")
    public void loggingAfterAdvice(JoinPoint joinPoint)  throws Throwable{
        LOGGER.info("{} has finished execution.", joinPoint.getSignature());
    }

}

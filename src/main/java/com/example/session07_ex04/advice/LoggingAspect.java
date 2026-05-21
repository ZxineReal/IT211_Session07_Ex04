package com.example.session07_ex04.advice;

import com.example.session07_ex04.exception.ResourceNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterThrowing(
            pointcut = "execution(* com.example.session07_ex04.service*.*(..))",
            throwing = "exception"
    )
    public void logServiceExceptions(JoinPoint joinPoint, ResourceNotFoundException exception) {

        logger.error("=== AUDIT LOG - RESOURCE NOT FOUND ===");
        logger.error("Thời gian: {}", LocalDateTime.now());
        logger.error("Method: {}.{}",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName());
        logger.error("Arguments: {}", Arrays.toString(joinPoint.getArgs()));
        logger.error("Exception message: {}", exception.getMessage());
        logger.error("Resource type: {}", exception.getResourceType());
        logger.error("Resource ID: {}", exception.getResourceId());

        if (logger.isDebugEnabled()) {
            logger.debug("Full stacktrace:", exception);
        }

        logger.error("=====================================");
    }

    @AfterThrowing(
            pointcut = "within(com.example.session07_ex04.service.*)",
            throwing = "exception"
    )
    public void logAllExceptions(JoinPoint joinPoint, Exception exception) {
        if (!(exception instanceof ResourceNotFoundException)) {
            logger.warn("UNEXPECTED EXCEPTION in Service Layer: {} - {}",
                    exception.getClass().getSimpleName(),
                    exception.getMessage());
        }
    }
}
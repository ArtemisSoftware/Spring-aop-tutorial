package com.artemissoftware.spring_aop.apects

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration

@Configuration
@Aspect
class LoggingAspect {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Before("execution(* com.artemissoftware.spring_aop.business.*.*(..))") //When?
    fun logMethodCall(joinPoint: JoinPoint){
        logger.info("Before aspect - Method is called -  $joinPoint")
    }
}
package com.artemissoftware.spring_aop.apects

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import java.lang.Exception

@Configuration
@Aspect
class LoggingAspect {

    private val logger = LoggerFactory.getLogger(this::class.java)

    //PointCut - When?
    @Before("execution(* com.artemissoftware.spring_aop.*.*.*(..))")
    fun logMethodCallBeforeExecution(joinPoint: JoinPoint){
        logger.info("Before aspect - Method is called -  $joinPoint args:${joinPoint.args.toList()}")
    }

    @After("execution(* com.artemissoftware.spring_aop.*.*.*(..))")
    fun logMethodCallAfterExecution(joinPoint: JoinPoint){
        logger.info("After aspect - Method was executed -  $joinPoint ")
    }

    @AfterThrowing(
        pointcut = "execution(* com.artemissoftware.spring_aop.*.*.*(..))",
        throwing = "exception"
    )
    fun logMethodCallAfterException(joinPoint: JoinPoint, exception: Exception) {
        logger.info("After Throwing - Method was executed -  $joinPoint ex:${exception.message}")
    }

    @AfterReturning(
        pointcut = "execution(* com.artemissoftware.spring_aop.*.*.*(..))",
        returning = "resultValue"
    )
    fun logMethodCallAfterReturning(joinPoint: JoinPoint, resultValue: Object) {
        logger.info("After Returning - Method was executed -  $joinPoint resultValue:$resultValue")
    }
}
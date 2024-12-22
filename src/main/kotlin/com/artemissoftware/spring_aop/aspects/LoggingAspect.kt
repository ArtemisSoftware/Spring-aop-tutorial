package com.artemissoftware.spring_aop.aspects

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration

@Configuration
@Aspect
class LoggingAspect {

    private val logger = LoggerFactory.getLogger(this::class.java)

    //PointCut - When?
    @Before("com.artemissoftware.spring_aop.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
    fun logMethodCallBeforeExecution(joinPoint: JoinPoint){
        logger.info("Before aspect - Method is called -  $joinPoint args:${joinPoint.args.toList()}")
    }

    @After("com.artemissoftware.spring_aop.aspects.CommonPointcutConfig.businessPackageConfig()")
    fun logMethodCallAfterExecution(joinPoint: JoinPoint){
        logger.info("After aspect - Method was executed -  $joinPoint ")
    }

    @AfterThrowing(
        pointcut = "com.artemissoftware.spring_aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
        throwing = "exception"
    )
    fun logMethodCallAfterException(joinPoint: JoinPoint, exception: Exception) {
        logger.info("After Throwing - Method was executed -  $joinPoint ex:${exception.message}")
    }

    @AfterReturning(
        pointcut = "com.artemissoftware.spring_aop.aspects.CommonPointcutConfig.dataPackageConfig()",
        returning = "resultValue"
    )
    fun logMethodCallAfterReturning(joinPoint: JoinPoint, resultValue: Object) {
        logger.info("After Returning - Method was executed -  $joinPoint resultValue:$resultValue")
    }
}
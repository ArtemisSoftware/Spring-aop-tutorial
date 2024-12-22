package com.artemissoftware.spring_aop.aspects

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration

@Configuration
@Aspect
class PerformanceTrackingAspect {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Around("com.artemissoftware.spring_aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
    @Throws(Throwable::class)
    fun findExecutionTime(proceedingJoinPoint: ProceedingJoinPoint): Any {
        //Start a timer
        val startTimeMillis = System.currentTimeMillis()

        //Execute the method
        val returnValue = proceedingJoinPoint.proceed()

        //Stop the timer
        val stopTimeMillis = System.currentTimeMillis()

        val executionDuration = stopTimeMillis - startTimeMillis

        logger.info("Around Aspect - $proceedingJoinPoint Method executed in $executionDuration ms")
        return returnValue
    }
}
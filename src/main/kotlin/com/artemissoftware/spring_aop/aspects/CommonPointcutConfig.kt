package com.artemissoftware.spring_aop.aspects

import org.aspectj.lang.annotation.Pointcut

class CommonPointcutConfig {
    @Pointcut("execution(* com.artemissoftware.spring_aop.*.*.*(..))")
    fun businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.artemissoftware.spring_aop.business.*.*(..))")
    fun businessPackageConfig() {}

    @Pointcut("execution(* com.artemissoftware.spring_aop.data.*.*(..))")
    fun dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    fun allPackageConfigUsingBean() {}
}
package dev.alimansour.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class MyDemoLoggingAspect {
    @Pointcut("execution(* dev.alimansour.aopdemo.dao.*.*(..))")
    fun forDaoPackage() {
    }

    @Before("forDaoPackage()")
    fun beforeAddAccountAdvice() {
        println("\n=====> Executing @Before advice on method")
    }
}

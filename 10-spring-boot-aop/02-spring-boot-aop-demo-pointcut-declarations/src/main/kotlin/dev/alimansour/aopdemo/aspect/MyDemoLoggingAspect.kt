package dev.alimansour.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class MyDemoLoggingAspect {
    @Pointcut("execution(* dev.alimansour.aopdemo.dao.*.*(..))")
    private fun forDaoPackage() {
    }

    @Pointcut("execution(* dev.alimansour.aopdemo.dao.*.get*(..))")
    private fun getter() {
    }

    @Pointcut("execution(* dev.alimansour.aopdemo.dao.*.set*(..))")
    private fun setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private fun forDaoPackageNoGetterSetter() {
    }

    @Before("forDaoPackageNoGetterSetter()")
    fun beforeAddAccountAdvice() {
        println("\n=====> Executing @Before advice on method")
    }

    @Before("forDaoPackageNoGetterSetter()")
    fun performApiAnalytics() {
        println("\n=====> Performing API analytics")
    }
}

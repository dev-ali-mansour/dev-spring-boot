package dev.alimansour.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

@Aspect
class LuvAopExpressions {
    @Pointcut("execution(* dev.alimansour.aopdemo.dao.*.*(..))")
    fun forDaoPackage() {
    }

    @Pointcut("execution(* dev.alimansour.aopdemo.dao.*.get*(..))")
    fun getter() {
    }

    @Pointcut("execution(* dev.alimansour.aopdemo.dao.*.set*(..))")
    fun setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    fun forDaoPackageNoGetterSetter() {
    }
}

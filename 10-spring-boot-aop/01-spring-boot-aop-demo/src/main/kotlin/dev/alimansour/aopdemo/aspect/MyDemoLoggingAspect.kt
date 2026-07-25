package dev.alimansour.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class MyDemoLoggingAspect {
    @Before("execution(* add*(..))")
    fun beforeAddAccountAdvice() {
        println("\n=====> Executing @Before advice on addAccount()")
    }
}

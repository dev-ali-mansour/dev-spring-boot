package dev.alimansour.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class MyDemoLoggingAspect {
    @Before("execution(public void dev.alimansour.aopdemo.dao.AccountDAO.addAccount())")
    fun beforeAddAccountAdvice() {
        println("\n=====> Executing @Before advice on addAccount()")
    }
}

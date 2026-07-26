package dev.alimansour.aopdemo.aspect

import dev.alimansour.aopdemo.Account
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(2)
class MyDemoLoggingAspect {

    @Around("execution(* dev.alimansour.aopdemo.service.*.getFortune(..))")
    fun aroundGetFortune(proceedingJoinPoint: ProceedingJoinPoint): Any {
        val method = proceedingJoinPoint.signature.toShortString()
        println("\n=====>>> Executing @Around on method: $method")

        val begin = System.currentTimeMillis()

        val result = runCatching {
            proceedingJoinPoint.proceed()
        }.getOrElse { t ->
            println(t.message)
            "Major accident! But no worries, your private AOP helicopter is on the way!"
        }

        val end = System.currentTimeMillis()

        val duration = end - begin

        println("\n=====>>> Duration: ${duration / 1000.0} seconds")

        return result
    }

    @After("execution(* dev.alimansour.aopdemo.dao.AccountDAO.findAccounts(..))")
    fun afterFinallyFindAccountAdvice(joinPoint: JoinPoint) {
        val method = joinPoint.signature.toShortString()
        println("\n=====>>> Executing @After (finally) on method: $method")
    }

    @AfterThrowing(
        pointcut = "execution(* dev.alimansour.aopdemo.dao.AccountDAO.findAccounts(..))",
        throwing = "exc"
    )
    fun afterThrowingFindAccountsAdvice(joinPoint: JoinPoint, exc: Throwable) {
        val method = joinPoint.signature.toShortString()
        println("\n=====>>> Executing @AfterThrowing on method: $method")

        println("\n=====>>> The exception is : ${exc.message}")
    }

    @AfterReturning(
        pointcut = "execution(* dev.alimansour.aopdemo.dao.AccountDAO.findAccounts(..))",
        returning = "result"
    )
    fun afterReturningFindAccountAdvice(joinPoint: JoinPoint, result: List<Account>) {
        val method = joinPoint.signature.toShortString()
        println("\n=====>>> Executing @AfterReturning on method: $method")

        println("\n=====>>> result is $result")

        val updatedResult = convertAccountNamesToUpperCase(result)

        println("\n=====>>> result is $updatedResult")
    }

    private fun convertAccountNamesToUpperCase(result: List<Account>): List<Account> {
        return result.map { account ->
            account.copy(name = account.name.uppercase())
        }
    }

    @Before("dev.alimansour.aopdemo.aspect.LuvAopExpressionsKt.forDaoPackageNoGetterSetter()")
    fun beforeAddAccountAdvice(joinPoint: JoinPoint) {
        println("\n=====>>> Executing @Before advice on method")

        val methodSignature = joinPoint.signature

        println("Method: $methodSignature")

        val args = joinPoint.args

        /*for (arg in args) {
            println(arg)
            if (arg is Account) {
                val account = arg as Account
                println("account name: ${account.name}")
                println("account level: ${account.level}")
            }
        }*/

        println("Args: ${args.contentToString()}")
    }
}

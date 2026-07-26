package dev.alimansour.aopdemo.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(2)
class MyDemoLoggingAspect {


    @Before("dev.alimansour.aopdemo.aspect.LuvAopExpressionsKt.forDaoPackageNoGetterSetter()")
    fun beforeAddAccountAdvice(joinPoint: JoinPoint) {
        println("\n=====> Executing @Before advice on method")

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

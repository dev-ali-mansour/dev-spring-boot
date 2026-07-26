package dev.alimansour.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(1)
class MyCloudLogAsyncAspect {
    @Before("dev.alimansour.aopdemo.aspect.LuvAopExpressionsKt.forDaoPackageNoGetterSetter()")
    fun logToCloudAsync() {
        println("\n=====>>> Logging to Cloud in async fashion")
    }
}

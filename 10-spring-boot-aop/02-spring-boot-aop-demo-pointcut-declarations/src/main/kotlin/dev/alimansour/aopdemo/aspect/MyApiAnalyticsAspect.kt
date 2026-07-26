package dev.alimansour.aopdemo.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Aspect
@Component
@Order(3)
class MyApiAnalyticsAspect {
    @Before("dev.alimansour.aopdemo.aspect.LuvAopExpressionsKt.forDaoPackageNoGetterSetter()")
    fun performApiAnalytics() {
        println("\n=====> Performing API analytics")
    }
}

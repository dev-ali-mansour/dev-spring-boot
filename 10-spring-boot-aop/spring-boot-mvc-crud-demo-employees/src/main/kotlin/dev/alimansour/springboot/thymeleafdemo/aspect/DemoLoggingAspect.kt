package dev.alimansour.springboot.thymeleafdemo.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Aspect
@Component
class DemoLoggingAspect {
    private val logger = Logger.getLogger(javaClass.name)

    @Pointcut("execution(* dev.alimansour.springboot.thymeleafdemo.controller.*.*(..))")
    fun forControllerPackage() {
    }

    @Pointcut("execution(* dev.alimansour.springboot.thymeleafdemo.service.*.*(..))")
    fun forServicePackage() {
    }

    @Pointcut("execution(* dev.alimansour.springboot.thymeleafdemo.dao.*.*(..))")
    fun forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    fun forAppFlow() {
    }

    @Before("forAppFlow()")
    fun before(joinPoint: JoinPoint) {
        val method = joinPoint.signature.toShortString()
        logger.info("=====>> in @Before: calling method: $method")

        val args = joinPoint.args

        for (arg in args) {
            logger.info("=====>> argument: $arg")
        }
    }

    @AfterReturning(
        pointcut = "forAppFlow()",
        returning = "result"
    )
    fun afterReturning(joinPoint: JoinPoint, result: Any?) {
        val method = joinPoint.signature.toShortString()
        logger.info("=====>> in @AfterReturning: from method: $method")

        logger.info(("=====>> result: $result"))
    }
}

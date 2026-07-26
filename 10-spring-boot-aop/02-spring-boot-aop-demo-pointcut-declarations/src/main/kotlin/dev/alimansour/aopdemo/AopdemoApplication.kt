package dev.alimansour.aopdemo

import dev.alimansour.aopdemo.dao.AccountDAO
import dev.alimansour.aopdemo.dao.MembershipDAO
import dev.alimansour.aopdemo.service.TrafficFortuneService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AopdemoApplication {
    @Bean
    fun commandLineRunner(
        accountDAO: AccountDAO,
        membershipDAO: MembershipDAO,
        trafficFortuneService: TrafficFortuneService,
    ): CommandLineRunner {
        return CommandLineRunner {
//            demoTheBeforeAdvice(accountDAO, membershipDAO)
//            demoTheAfterReturningAdvice(accountDAO)
//            demoTheAfterThrowingAdvice(accountDAO)
//            demoTheAfterAdvice(accountDAO)
            demoTheAroundAdvice(trafficFortuneService)
        }
    }

    private fun demoTheAroundAdvice(trafficFortuneService: TrafficFortuneService) {
        println("\nMain Program: demoTheAroundAdvice()")

        println("Calling getFortune()")

        val data = trafficFortuneService.getFortune()

        println("\nMyFortune is :$data")

        println("Finished")
    }

    private fun demoTheAfterAdvice(accountDAO: AccountDAO) {
        var accounts: List<Account>? = null

        runCatching {
            val tripWire = false
            accounts = accountDAO.findAccounts(tripWire)
        }.onFailure { exc ->
            println("\n\nMain Program: ... caught exception: $exc")
        }

        println("\n\nMain Program: demoAfterThrowingAdvice")
        println("----")

        println(accounts)

        println("\n")
    }

    private fun demoTheAfterThrowingAdvice(accountDAO: AccountDAO) {
        var accounts: List<Account>? = null

        runCatching {
            val tripWire = true
            accounts = accountDAO.findAccounts(tripWire)
        }.onFailure { exc ->
            println("\n\nMain Program: ... caught exception: $exc")
        }

        println("\n\nMain Program: demoAfterThrowingAdvice")
        println("----")

        println(accounts)

        println("\n")
    }

    private fun demoTheAfterReturningAdvice(accountDAO: AccountDAO) {
        val accounts = accountDAO.findAccounts()

        println("\n\nMain Program: demoAfterReturningAdvice")
        println("----")

        println(accounts)

        println("\n")
    }

    private fun demoTheBeforeAdvice(
        accountDAO: AccountDAO,
        membershipDAO: MembershipDAO
    ) {
        val account = Account(name = "Madhu", level = "Platinum")
        accountDAO.addAccount(account, true)
        accountDAO.doWork()

        accountDAO.name = "foobar"
        accountDAO.serviceCode = "silver"

        val name = accountDAO.name
        val code = accountDAO.serviceCode

        println("Name: $name, Service Code: $code")

        membershipDAO.addSillyMember()
        membershipDAO.goToSleep()
    }
}

fun main(args: Array<String>) {
    runApplication<AopdemoApplication>(*args)
}

package dev.alimansour.aopdemo.dao

import dev.alimansour.aopdemo.Account
import org.springframework.stereotype.Repository

@Repository
class AccountDAOImpl : AccountDAO {
    override var name: String? = null
        get() {
            println("$javaClass: in getName()")
            return field
        }
        set(value) {
            println("$javaClass: in setName()")
            field = value
        }
    override var serviceCode: String? = null
        get() {
            println("$javaClass: in getServiceCode()")
            return field
        }
        set(value) {
            println("$javaClass: in setServiceCode()")
            field = value
        }

    override fun findAccounts(): List<Account> {
        return findAccounts(false)
    }

    override fun findAccounts(tripWire: Boolean): List<Account> {
        if (tripWire) {
            throw RuntimeException("No soup for you!!!")
        }

        val accounts = mutableListOf<Account>()

        val account1 = Account(name = "John", level = "Silver")
        val account2 = Account(name = "Madhu", level = "Platinum")
        val account3 = Account(name = "Luca", level = "Gold")

        accounts.add(account1)
        accounts.add(account2)
        accounts.add(account3)

        return accounts
    }

    override fun addAccount(account: Account, vipFlag: Boolean) {
        println("$javaClass: DOING MY DB WORK: ADDING AN ACCOUNT")
    }

    override fun doWork(): Boolean {
        println("$javaClass: doWork()")
        return false
    }
}

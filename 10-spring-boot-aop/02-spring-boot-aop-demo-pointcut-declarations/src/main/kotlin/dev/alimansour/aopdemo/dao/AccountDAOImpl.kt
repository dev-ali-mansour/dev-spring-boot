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

    override fun addAccount(account: Account, vipFlag: Boolean) {
        println("$javaClass: DOING MY DB WORK: ADDING AN ACCOUNT")
    }

    override fun doWork(): Boolean {
        println("$javaClass: doWork()")
        return false
    }
}

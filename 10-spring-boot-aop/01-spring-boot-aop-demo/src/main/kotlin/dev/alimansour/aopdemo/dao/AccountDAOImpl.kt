package dev.alimansour.aopdemo.dao

import dev.alimansour.aopdemo.Account
import org.springframework.stereotype.Repository

@Repository
class AccountDAOImpl : AccountDAO {
    override fun addAccount(account: Account, vipFlag: Boolean) {
        println("$javaClass: DOING MY DB WORK: ADDING AN ACCOUNT")
    }

    override fun doWork(): Boolean {
        println("$javaClass: doWork()")
        return false
    }
}

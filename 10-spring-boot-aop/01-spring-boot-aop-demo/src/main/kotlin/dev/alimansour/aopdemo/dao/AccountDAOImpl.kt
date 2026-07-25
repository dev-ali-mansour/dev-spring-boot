package dev.alimansour.aopdemo.dao

import dev.alimansour.aopdemo.Account
import org.springframework.stereotype.Repository

@Repository
class AccountDAOImpl : AccountDAO {
    override fun addAccount(account: Account, vipFlag: Boolean) {
        println("$javaClass: DOING MY WORK: ADDING AN ACCOUNT")
    }
}

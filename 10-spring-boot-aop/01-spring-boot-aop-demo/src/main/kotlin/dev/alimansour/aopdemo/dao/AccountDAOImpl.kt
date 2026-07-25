package dev.alimansour.aopdemo.dao

import org.springframework.stereotype.Repository

@Repository
class AccountDAOImpl : AccountDAO {
    override fun addAccount() {
        println("$javaClass: DOING MY WORK: ADDING AN ACCOUNT")
    }
}

package dev.alimansour.aopdemo.dao

import dev.alimansour.aopdemo.Account

interface AccountDAO {
    var name: String?
    var serviceCode: String?
    fun findAccounts(): List<Account>
    fun addAccount(account: Account, vipFlag: Boolean)
    fun doWork(): Boolean
}

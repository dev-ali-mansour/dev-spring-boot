package dev.alimansour.aopdemo.dao

import dev.alimansour.aopdemo.Account

interface AccountDAO {
    var name: String?
    var serviceCode: String?
    fun addAccount(account: Account, vipFlag: Boolean)
    fun doWork(): Boolean
}

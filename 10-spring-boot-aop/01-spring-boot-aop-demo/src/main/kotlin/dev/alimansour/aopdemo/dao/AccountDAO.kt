package dev.alimansour.aopdemo.dao

import dev.alimansour.aopdemo.Account

interface AccountDAO {
    fun addAccount(account: Account)
}

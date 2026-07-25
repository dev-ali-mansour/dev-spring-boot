package dev.alimansour.aopdemo.dao

import org.springframework.stereotype.Repository
import kotlin.math.log

@Repository
class MembershipDAOImpl : MembershipDAO {
    override fun addSillyMember(): Boolean {
        println("$javaClass: DOING MY WORK: ADDING A MEMBERSHIP ACCOUNT")
        return true
    }

    override fun goToSleep() {
        println("$javaClass: I'm going to sleep now...")
    }
}

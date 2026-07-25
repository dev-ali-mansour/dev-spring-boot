package dev.alimansour.aopdemo.dao

import org.springframework.stereotype.Repository

@Repository
class MembershipDAOImpl : MembershipDAO {
    override fun addSillyMember() {
        println("$javaClass: DOING MY WORK: ADDING A MEMBERSHIP ACCOUNT")
    }
}

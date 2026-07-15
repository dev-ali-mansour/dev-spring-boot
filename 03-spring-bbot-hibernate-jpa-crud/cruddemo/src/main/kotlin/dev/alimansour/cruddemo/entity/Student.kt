package dev.alimansour.cruddemo.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "student")
class Student() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @Column(name = "first_name")
    var firstName: String = ""

    @Column(name = "last_name")
    var lastName: String = ""

    @Column(name = "email")
    var email: String = ""

    constructor(firstName: String, lastName: String, email: String) : this() {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

    override fun toString(): String {
        return "Student{id=$id, firstName='$firstName', lastName='$lastName', email='$email'}"
    }
}

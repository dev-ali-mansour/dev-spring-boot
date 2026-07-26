package dev.alimansour.springboot.thymeleafdemo.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "employee")
class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0,
    @Column(name = "first_name")
    var firstName: String = "",
    @Column(name = "last_name")
    var lastName: String = "",
    @Column(name = "email")
    var email: String = ""
) {

    // define toString
    override fun toString(): String {
        return "Employee(id=$id, firstName='$firstName', lastName='$lastName', email='$email')"
    }
}

package dev.alimansour.springboot.thymeleafdemo.dao

import dev.alimansour.springboot.thymeleafdemo.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long> {
    fun findAllByOrderByLastNameDesc(): List<Employee>
}

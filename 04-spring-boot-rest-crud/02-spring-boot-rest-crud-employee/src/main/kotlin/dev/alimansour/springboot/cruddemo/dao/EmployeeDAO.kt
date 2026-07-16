package dev.alimansour.springboot.cruddemo.dao

import dev.alimansour.springboot.cruddemo.entity.Employee

interface EmployeeDAO {
    fun findAll(): List<Employee>

    fun findById(id: Long): Employee?

    fun save(employee: Employee): Employee

    fun deleteById(id: Long)
}

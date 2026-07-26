package dev.alimansour.springboot.thymeleafdemo.service

import dev.alimansour.springboot.thymeleafdemo.entity.Employee

interface EmployeeService {
    fun findAll(): List<Employee>

    fun findById(id: Long): Employee

    fun save(employee: Employee): Employee

    fun deleteById(id: Long)
}

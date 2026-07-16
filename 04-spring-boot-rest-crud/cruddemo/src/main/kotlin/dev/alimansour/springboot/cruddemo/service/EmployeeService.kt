package dev.alimansour.springboot.cruddemo.service

import dev.alimansour.springboot.cruddemo.entity.Employee

interface EmployeeService {
    fun findAll(): List<Employee>
}

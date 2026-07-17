package dev.alimansour.springboot.cruddemo.dao

import dev.alimansour.springboot.cruddemo.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long>

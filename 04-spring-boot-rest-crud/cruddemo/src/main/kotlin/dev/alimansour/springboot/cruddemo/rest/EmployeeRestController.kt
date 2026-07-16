package dev.alimansour.springboot.cruddemo.rest

import dev.alimansour.springboot.cruddemo.dao.EmployeeDAO
import dev.alimansour.springboot.cruddemo.entity.Employee
import dev.alimansour.springboot.cruddemo.service.EmployeeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmployeeRestController(
    private val employeeService: EmployeeService
) {
    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    fun findAll(): List<Employee> {
        return employeeService.findAll()
    }
}

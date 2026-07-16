package dev.alimansour.springboot.cruddemo.rest

import dev.alimansour.springboot.cruddemo.entity.Employee
import dev.alimansour.springboot.cruddemo.service.EmployeeService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmployeeRestController(
    private val employeeService: EmployeeService
) {
    @GetMapping("/employees")
    fun findAll(): List<Employee> {
        return employeeService.findAll()
    }

    @GetMapping("/employees/{employeeId}")
    fun findById(@PathVariable employeeId: Long): Employee {
        val employee = employeeService.findById(employeeId)
            ?: throw IllegalArgumentException("Employee id not found - $employeeId")
        return employee
    }

    @PostMapping("/employees")
    fun save(@RequestBody employee: Employee): Employee {
        employee.id = 0
        return employeeService.save(employee)
    }

    @PutMapping("/employees")
    fun update(@RequestBody employee: Employee): Employee {
        return employeeService.save(employee)
    }

    @DeleteMapping("/employees/{employeeId}")
    fun delete(@PathVariable employeeId: Long): String {
        val employee = employeeService.findById(employeeId)
            ?: throw IllegalArgumentException("Employee id not found - $employeeId")
        employeeService.deleteById(employeeId)
        return "Deleted employee id - $employeeId"
    }
}

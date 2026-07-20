package dev.alimansour.springboot.cruddemo.controller

import dev.alimansour.springboot.cruddemo.service.EmployeeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/employees")
class EmployeeController(employeesService: EmployeeService, private val employeeService: EmployeeService) {
        @GetMapping("/list")
    fun listEmployees(model: Model): String {
        val employees = employeeService.findAll()

        model.addAttribute("employees", employees)

        return "list-employees"
    }

}

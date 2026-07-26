package dev.alimansour.springboot.thymeleafdemo.controller

import dev.alimansour.springboot.thymeleafdemo.entity.Employee
import dev.alimansour.springboot.thymeleafdemo.service.EmployeeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/employees")
class EmployeeController(employeesService: EmployeeService, private val employeeService: EmployeeService) {
    @GetMapping("/list")
    fun listEmployees(model: Model): String {
        val employees = employeeService.findAll()

        model.addAttribute("employees", employees)

        return "employees/list-employees"
    }

    @GetMapping("showFormForAdd")
    fun showFormForAdd(model: Model): String {
        val employee = Employee()

        model.addAttribute("employee", employee)

        return "employees/employee-form"
    }

    @GetMapping("/showFormForUpdate")
    fun showFormForUpdate(
        @RequestParam("employeeId") employeeId: Long,
        model: Model
    ): String {
        val employee = employeeService.findById(employeeId)

        model.addAttribute("employee", employee)

        return "employees/employee-form"
    }

    @PostMapping("/save")
    fun saveEmployee(@ModelAttribute("employee") employee: Employee): String {

        employeeService.save(employee)

        return "redirect:/employees/list"
    }

    @GetMapping("/delete")
    fun delete(@RequestParam("employeeId") employeeId: Long): String {
        employeeService.deleteById(employeeId)

        return "redirect:/employees/list"
    }
}

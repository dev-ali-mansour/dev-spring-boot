package dev.alimansour.springboot.cruddemo.service

import dev.alimansour.springboot.cruddemo.dao.EmployeeDAO
import dev.alimansour.springboot.cruddemo.entity.Employee
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(
    private val employeeDAO: EmployeeDAO
) : EmployeeService {
    override fun findAll(): List<Employee> {
        return employeeDAO.findAll()
    }
}

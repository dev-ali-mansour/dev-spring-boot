package dev.alimansour.springboot.cruddemo.service

import dev.alimansour.springboot.cruddemo.dao.EmployeeDAO
import dev.alimansour.springboot.cruddemo.entity.Employee
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(
    private val employeeDAO: EmployeeDAO
) : EmployeeService {
    override fun findAll(): List<Employee> {
        return employeeDAO.findAll()
    }

    override fun findById(id: Long): Employee? {
        return employeeDAO.findById(id)
    }

    @Transactional
    override fun save(employee: Employee): Employee {
        return employeeDAO.save(employee)
    }

    @Transactional
    override fun deleteById(id: Long) {
        employeeDAO.deleteById(id)
    }
}

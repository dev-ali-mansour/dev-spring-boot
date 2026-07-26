package dev.alimansour.springboot.thymeleafdemo.service

import dev.alimansour.springboot.thymeleafdemo.dao.EmployeeRepository
import dev.alimansour.springboot.thymeleafdemo.entity.Employee
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(
    private val employeeRepository: EmployeeRepository
) : EmployeeService {
    override fun findAll(): List<Employee> {
        return employeeRepository.findAllByOrderByLastNameDesc()
    }

    override fun findById(id: Long): Employee {
        return employeeRepository.findById(id).orElseThrow{
            EntityNotFoundException("Employee with id $id not found")
        }
    }

    override fun save(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    override fun deleteById(id: Long) {
        employeeRepository.deleteById(id)
    }
}

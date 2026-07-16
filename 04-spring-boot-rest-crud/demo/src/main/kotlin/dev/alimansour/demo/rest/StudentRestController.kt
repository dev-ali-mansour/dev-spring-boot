package dev.alimansour.demo.rest

import dev.alimansour.demo.entity.Student
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class StudentRestController {

    // define endpoint for "/students" - return a list of Student
    @GetMapping("/students")
    fun getStudents(): List<Student> {
        val students = mutableListOf<Student>()
        students.add(Student("Poornima","Patel"))
        students.add(Student("Mario","Rossi"))
        students.add(Student("Mary","Smith"))
        return students
    }
}

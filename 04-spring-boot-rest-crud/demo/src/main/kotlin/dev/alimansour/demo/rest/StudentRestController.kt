package dev.alimansour.demo.rest

import dev.alimansour.demo.entity.Student
import jakarta.annotation.PostConstruct
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class StudentRestController {

    private lateinit var students: MutableList<Student>

    // define @PostConstruct to load the student data ... only once!

    @PostConstruct
    fun loadData() {
        students = mutableListOf()
        students.add(Student("Poornima", "Patel"))
        students.add(Student("Mario", "Rossi"))
        students.add(Student("Mary", "Smith"))
    }

    // define endpoint for "/students" - return a list of Student

    @GetMapping("/students")
    fun getStudents(): List<Student> {
        return students
    }
}

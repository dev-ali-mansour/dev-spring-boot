package dev.alimansour.demo.rest

import dev.alimansour.demo.entity.Student
import jakarta.annotation.PostConstruct
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    // define endpoint for "/students/{studentId}" - return Student at index

    @GetMapping("students/{studentId}")
    fun getStudent(@PathVariable studentId: Int): Student {

        // just index into the list ... keep it simple for now

        // check the studentId against list size

        if (studentId >= students.size || studentId < 0)
            throw StudentNotFoundException("Student id not found - $studentId")

        return students[studentId]
    }
}

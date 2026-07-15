package dev.alimansour.cruddemo

import dev.alimansour.cruddemo.dao.StudentDao
import dev.alimansour.cruddemo.entity.Student
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CruddemoApplication {

    @Bean
    fun commandLineRunner(studentDao: StudentDao): CommandLineRunner {
        return CommandLineRunner { runner ->
//            createStudent(studentDao)
            createMultipleStudents(studentDao)
//            readStudent(studentDao)
//            queryForStudents(studentDao)
//            queryForStudentsByLastName(studentDao)
//            updateStudent(studentDao)
//            deleteStudent(studentDao)
//            deleteAllStudents(studentDao)
        }
    }

    private fun deleteAllStudents(studentDao: StudentDao) {
        println("Deleting all students ...")
        val numRowsDeleted = studentDao.deleteAll()
        println("Deleted row count: $numRowsDeleted")
    }

    private fun deleteStudent(studentDao: StudentDao) {
        // retrieve student based on the id: primary key
        val studentId: Long = 3
        val student = studentDao.findById(studentId)
        println("Found student: $student")

        // delete the student
        studentDao.delete(studentId)
        println("Deleted student: $student")
    }

    private fun updateStudent(studentDao: StudentDao) {
        // retrieve student based on the id: primary key
        val studentId: Long = 1
        val student = studentDao.findById(studentId)
        println("Found student: $student")

        // update details of the student
        println("Updating student ...")
        student.firstName = "John"

        // update the student
        studentDao.update(student)

        // display the updated student
        val updatedStudent = studentDao.findById(studentId)
        println("Updated student: $updatedStudent")
    }

    private fun queryForStudentsByLastName(studentDao: StudentDao) {
        // get a list of students
        val students = studentDao.findByLastName("Duck")
        // display list of students
        for (student in students) {
            println(student)
        }
    }

    private fun queryForStudents(studentDao: StudentDao) {
        // get a list of students
        val students = studentDao.findAll()

        // display list of students
        for (student in students) {
            println(student)
        }
    }

    private fun readStudent(studentDao: StudentDao) {
        // create a student object
        println("Creating new student object ...")
        val student = Student("Daffy", "Duck", "daffy.duck@gmail.com")

        // save the student
        println("Saving the student ...")
        studentDao.save(student)

        // display id of the saved student
        val id = student.id
        println("Saved student. Generated id: $id")

        // retrieve student based on id: primary key
        println("Retrieving student with id: $id")
        val retrievedStudent = studentDao.findById(id)

        // display student
        println("Found the student: $retrievedStudent")
    }

    private fun createMultipleStudents(studentDao: StudentDao) {
        // Create multiple students
        println("Creating 3 student objects ...")
        val student1 = Student("John", "Doe", "john.doe@gmail.com")
        val student2 = Student("Mary", "Public", "mary.public@gmail.com")
        val student3 = Student("Bonita", "Applebum", "bonita.applebum@gmail.com")

        // Save the student objects
        println("Saving the students ...")
        studentDao.save(student1)
        studentDao.save(student2)
        studentDao.save(student3)
    }

    private fun createStudent(studentDao: StudentDao) {
        // Create the student object
        println("Creating new student object ...")
        val student = Student("Ali", "Mansour", "dev.ali.mansour@gmail.com")

        // Save the student object
        println("Saving the student ...")
        studentDao.save(student)

        // Display id of the saved student
        println("Saved student. Generated id: " + student.id)
    }
}

fun main(args: Array<String>) {
    runApplication<CruddemoApplication>(*args)
}


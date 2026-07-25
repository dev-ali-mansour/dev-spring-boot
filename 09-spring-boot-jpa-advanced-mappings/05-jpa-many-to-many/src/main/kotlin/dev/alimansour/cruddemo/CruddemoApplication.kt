package dev.alimansour.cruddemo

import dev.alimansour.cruddemo.dao.AppDAO
import dev.alimansour.cruddemo.entity.*
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CruddemoApplication {
    @Bean
    fun commandLineRunner(appDAO: AppDAO): CommandLineRunner {
        return CommandLineRunner {
//            createCourseAndStudent(appDAO)
//            findCourseAndStudents(appDAO)
//            findStudentAndCourses(appDAO)
//            addMoreCoursesForStudent(appDAO)
            deleteCourse(appDAO)
        }
    }

    private fun addMoreCoursesForStudent(appDAO: AppDAO) {
        val id = 2
        val student = appDAO.findStudentAndCoursesByStudentId(id)

        val course1 = Course(title = "Rubik's Cube - How to Speed Cube")
        val course2 = Course(title = "Atari 2600 - Game Development")

        student?.let { student ->
            student.addCourse(course1)
            student.addCourse(course2)

            println("Updating student : $student")
            println("The attached courses: ${student.courses}")

            appDAO.update(student)

            println("Done!")
        }
    }

    private fun findStudentAndCourses(appDAO: AppDAO) {
        val id = 2
        val student = appDAO.findStudentAndCoursesByStudentId(id)

        student?.let { loaded ->
            println("Loaded student: $loaded")
            println("Courses: ${loaded.courses}")

            println("Done!")
        }
    }

    private fun findCourseAndStudents(appDAO: AppDAO) {
        val id = 10
        val course = appDAO.findCourseAndStudentsByCourseId(id)

        course?.let { loaded ->
            println("Loaded course:$loaded")
            println("Students: ${loaded.students}")

            println("Done!")
        }
    }

    private fun createCourseAndStudent(appDAO: AppDAO) {
        val course = Course(title = "Pacman - How To Score One Million Points")

        val student1 = Student(firstName = "John", lastName = "Doe", email = "john@luv2code.com")
        val student2 = Student(firstName = "Mary", lastName = "Public", email = "mary@luv2code.com")

        course.addStudent(student1)
        course.addStudent(student2)

        println("Saving the course: $course")
        println("The associated students: ${course.students}")

        appDAO.save(course)

        println("Done!")

    }

    private fun deleteCourseAndReviews(appDAO: AppDAO) {
        val id = 10

        println("Deleting course with id: $id")

        appDAO.deleteCourseById(id)

        println("Done!")
    }

    private fun retrieveCourseAndReviews(appDAO: AppDAO) {
        val id = 10

        val course = appDAO.findCourseAndReviewsByCourseId(id)
        course?.let { foundCourse ->
            println(foundCourse)

            println(foundCourse.reviews)

            println("Done!")
        }
    }

    private fun createCourseAndReviews(appDAO: AppDAO) {
        val course = Course(title = "Pacman - How To Score One Million Points")

        course.add(Review(comment = "Great course ... loved it!"))
        course.add(Review(comment = "Cool course, job well done."))
        course.add(Review(comment = "What a dumb course, you are an idiot!"))

        println("Saving the course")
        println(course)
        println(course.reviews)

        appDAO.save(course)

        println("Done!")
    }

    private fun deleteCourse(appDAO: AppDAO) {
        val id = 10

        println("Finding course with id: $id")
        val course = appDAO.findCourseById(id)

        course?.let {
            println("Deleting course with id: $id")
            appDAO.deleteCourseById(id)

            print("Done!")
        }
    }

    private fun updateCourse(appDAO: AppDAO) {
        val id = 10

        println("Finding course with id: $id")
        val course = appDAO.findCourseById(id)

        println("Updating course with id: $id")
        course?.let { foundCourse ->
            foundCourse.title = "Enjoy the Simple Things"

            appDAO.update(foundCourse)

            println("Done!")
        }
    }

    private fun updateInstructor(appDAO: AppDAO) {
        val id = 1

        println("Finding instructor with id: $id")
        val instructor = appDAO.findInstructorById(id)

        instructor?.let { foundInstructor ->
            println("Updating instructor with id: $id")
            foundInstructor.lastName = "TESTER"

            appDAO.update(foundInstructor)

            println("Done!")
        }
    }

    private fun findInstructorWithCoursesJoinFetch(appDAO: AppDAO) {
        val id = 1
        println("Finding instructor with id: $id")

        val instructor = appDAO.findInstructorByIdJoinFetch(id)

        println("Instructor: $instructor")

        println("The associated courses: ${instructor?.courses}")

        println("Done!")
    }

    private fun findCoursesByInstructor(appDAO: AppDAO) {
        val id = 1
        println("Finding instructor by id: $id")

        val instructor = appDAO.findInstructorById(id)

        println("Instructor: $instructor")

        println("Finding courses for constructor id: $id")
        val courses = appDAO.findCoursesByInstructorId(id)

        // Replacing the collection entirely is considered an antipattern in JPA
        // Todo Replace this approach with `JoinFetch`
        instructor?.courses = courses.toMutableList()

        println("The associated courses: ${instructor?.courses}")

        println("Done!")
    }

    private fun findInstructorWithCourses(appDAO: AppDAO) {
        val id = 1
        println("Finding instructor by id: $id")

        val instructor = appDAO.findInstructorById(id)

        println("Instructor: $instructor")
        println("The associated courses: ${instructor?.courses}")
    }

    private fun createInstructorWithCourses(appDAO: AppDAO) {
        val instructor = Instructor(firstName = "Susan", lastName = "Public", email = "susan.public@luv2code.com")
        val instructorDetail = InstructorDetail(
            youtubeChannel = "https://www.luv2code.com",
            hobby = "Video Games"
        )

        instructor.instructorDetail = instructorDetail

        val course1 = Course(title = "Air Guitar - The Ultimate Guide")
        val course2 = Course(title = "The Pinball Masterclass")

        instructor.add(course1)
        instructor.add(course2)

        println("Saving instructor: $instructor")
        println("The courses: ${instructor.courses}")
        appDAO.save(instructor)

        println("Done!")
    }

    private fun deleteInstructorDetail(appDAO: AppDAO) {
        val id = 3
        println("deleting instructor detail with id: $id")
        appDAO.deleteInstructorDetailById(id)
        println("Done")
    }

    private fun findInstructorDetail(appDAO: AppDAO) {
        val id = 2
        val instructorDetail = appDAO.findInstructorDetailById(id)
        println("instructorDetail: $instructorDetail")
        println("The associated instructor is ${instructorDetail?.instructor}")
    }

    private fun deleteInstructor(appDAO: AppDAO) {
        val id = 1
        println("Deleting instructor with id: $id")

        appDAO.deleteInstructorById(id)

        println("Done")
    }

    private fun findInstructor(appDAO: AppDAO) {
        val id = 2
        println("Finding instructor id $id")
        val instructor = appDAO.findInstructorById(id)
        println("Instructor: $instructor")
        println("The associated instructorDetail only: ${instructor?.instructorDetail}")
    }

    private fun createInstructor(appDAO: AppDAO) {
        /*val instructor = Instructor(firstName = "Chad", lastName = "Darby", email = "darby@luv2code.com")
        val instructorDetail = InstructorDetail(
            youtubeChannel = "https://www.luv2code.com/youtube",
            hobby = "LUV 2 code!!!"
        )*/
        val instructor = Instructor(firstName = "Madhu", lastName = "Patel", email = "madhu@luv2code.com")
        val instructorDetail = InstructorDetail(
            youtubeChannel = "https://www.luv2code.com/youtube",
            hobby = "Guitar"
        )
        instructor.instructorDetail = instructorDetail
        println("Saving instructor: $instructor")
        appDAO.save(instructor)
    }
}

fun main(args: Array<String>) {
    runApplication<CruddemoApplication>(*args)
}

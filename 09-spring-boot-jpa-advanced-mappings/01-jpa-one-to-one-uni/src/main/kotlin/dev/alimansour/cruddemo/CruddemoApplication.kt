package dev.alimansour.cruddemo

import dev.alimansour.cruddemo.dao.AppDAO
import dev.alimansour.cruddemo.entity.Instructor
import dev.alimansour.cruddemo.entity.InstructorDetail
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class CruddemoApplication {
    @Bean
    fun commandLineRunner(appDAO: AppDAO): CommandLineRunner {
        return CommandLineRunner {
//            createInstructor(appDAO)
            findInstructor(appDAO)
            deleteInstructor(appDAO)
        }
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

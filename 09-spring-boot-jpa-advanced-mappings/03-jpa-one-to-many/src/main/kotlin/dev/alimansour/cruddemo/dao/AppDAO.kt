package dev.alimansour.cruddemo.dao

import dev.alimansour.cruddemo.entity.Instructor
import dev.alimansour.cruddemo.entity.InstructorDetail

interface AppDAO {
    fun save(instructor: Instructor)
    fun findInstructorById(id: Int): Instructor?
    fun deleteInstructorById(id: Int)
    fun findInstructorDetailById(id: Int): InstructorDetail?
    fun deleteInstructorDetailById(id: Int)
}

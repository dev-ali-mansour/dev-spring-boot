package dev.alimansour.cruddemo.dao

import dev.alimansour.cruddemo.entity.Instructor

interface AppDAO {
    fun save(instructor: Instructor)
    fun findInstructorById(id: Int): Instructor?
    fun deleteInstructorById(id: Int)
}

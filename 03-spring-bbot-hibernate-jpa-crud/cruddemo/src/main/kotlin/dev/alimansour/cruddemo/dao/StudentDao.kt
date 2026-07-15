package dev.alimansour.cruddemo.dao

import dev.alimansour.cruddemo.entity.Student

interface StudentDao {
    fun save(student: Student)

    fun findById(id: Long): Student

    fun findAll(): List<Student>

    fun findByLastName(value: String): List<Student>

    fun update(student: Student)

    fun delete(id: Long)

    fun deleteAll(): Int
}

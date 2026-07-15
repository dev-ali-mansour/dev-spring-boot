package dev.alimansour.cruddemo.dao

import dev.alimansour.cruddemo.entity.Student
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class StudentDaoImpl(
    private val entityManager: EntityManager
) : StudentDao {
    @Transactional
    override fun save(student: Student) {
        entityManager.persist(student)
    }

    override fun findById(id: Long): Student {
        return entityManager.find(Student::class.java, id)
    }

    override fun findAll(): List<Student> {
        // create query
        val query = entityManager.createQuery("FROM Student order by lastName desc", Student::class.java)

        // return query results
        return query.resultList
    }

    override fun findByLastName(value: String): List<Student> {
        // create query
        val query = entityManager.createQuery("FROM Student WHERE lastName=:lastName", Student::class.java)

        // set query parameters
        query.setParameter("lastName", value)

        // return query results
        return query.resultList
    }

    @Transactional
    override fun update(student: Student) {
        entityManager.merge(student)
    }

    @Transactional
    override fun delete(id: Long) {
        // retrieve the student
        val student = entityManager.find(Student::class.java, id)

        //delete the student
        entityManager.remove(student)

        // Alternative approach
//        entityManager
//            .createQuery("DELETE FROM Student WHERE id=:id")
//            .setParameter("id", id)
//            .executeUpdate()
    }

    @Transactional
    override fun deleteAll(): Int {
        val numRowsDeleted = entityManager
            .createQuery("DELETE FROM Student")
            .executeUpdate()
        return numRowsDeleted
    }
}

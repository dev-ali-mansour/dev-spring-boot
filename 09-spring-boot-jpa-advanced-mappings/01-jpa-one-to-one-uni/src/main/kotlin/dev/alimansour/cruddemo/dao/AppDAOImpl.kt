package dev.alimansour.cruddemo.dao

import dev.alimansour.cruddemo.entity.Instructor
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class AppDAOImpl(private val entityManager: EntityManager) : AppDAO {

    @Transactional
    override fun save(instructor: Instructor) {
        entityManager.persist(instructor)
    }

    override fun findInstructorById(id: Int): Instructor? {
        return entityManager.find(Instructor::class.java, id)
    }

    @Transactional
    override fun deleteInstructorById(id: Int) {
        val instructor = entityManager.find(Instructor::class.java, id)
        entityManager.remove(instructor)
    }
}

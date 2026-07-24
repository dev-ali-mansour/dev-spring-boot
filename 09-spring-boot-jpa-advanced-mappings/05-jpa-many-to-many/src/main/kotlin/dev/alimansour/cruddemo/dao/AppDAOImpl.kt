package dev.alimansour.cruddemo.dao

import dev.alimansour.cruddemo.entity.Course
import dev.alimansour.cruddemo.entity.Instructor
import dev.alimansour.cruddemo.entity.InstructorDetail
import dev.alimansour.cruddemo.entity.Student
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

        for (course in instructor.courses) {
            course.instructor = null
        }

        entityManager.remove(instructor)
    }

    override fun findInstructorDetailById(id: Int): InstructorDetail? {
        return entityManager.find(InstructorDetail::class.java, id)
    }

    @Transactional
    override fun deleteInstructorDetailById(id: Int) {
        val instructorDetail = entityManager.find(InstructorDetail::class.java, id)

        // break bi-directional link
        instructorDetail?.instructor?.instructorDetail = null

        entityManager.remove(instructorDetail)
    }

    override fun findCoursesByInstructorId(instructorId: Int): List<Course> {
        val query = entityManager.createQuery(
            "FROM Course WHERE instructor.id=:data", Course::class.java
        )
        query.setParameter("data", instructorId)

        return query.resultList
    }

    override fun findInstructorByIdJoinFetch(instructorId: Int): Instructor? {
        val query = entityManager.createQuery(
            "SELECT i FROM Instructor i " + "JOIN FETCH i.courses " + "JOIN FETCH i.instructorDetail " + "WHERE i.id=:data",
            Instructor::class.java
        )
        query.setParameter("data", instructorId)

        return query.singleResult
    }

    @Transactional
    override fun update(instructor: Instructor) {
        entityManager.merge(instructor)
    }

    override fun findCourseById(id: Int): Course? {
        return entityManager.find(Course::class.java, id)
    }

    @Transactional
    override fun update(course: Course) {
        entityManager.merge(course)
    }

    @Transactional
    override fun deleteCourseById(id: Int) {
        val course = entityManager.find(Course::class.java, id)

        entityManager.remove(course)
    }

    @Transactional
    override fun save(course: Course) {
        entityManager.persist(course)
    }

    override fun findCourseAndReviewsByCourseId(courseId: Int): Course? {
        val query = entityManager.createQuery(
            "select c from Course c " + "join fetch c.reviews " + "where c.id=:data", Course::class.java
        )
        query.setParameter("data", courseId)
        return query.singleResult
    }

    override fun findCourseAndStudentsByCourseId(courseId: Int): Course? {
        val query = entityManager.createQuery(
            "select c from Course c " + "join fetch c.students " + "where c.id=:data", Course::class.java
        )
        query.setParameter("data", courseId)

        return query.singleResult
    }

    override fun findStudentAndCoursesByStudentId(studentId: Int): Student? {
        val query = entityManager.createQuery(
            "select s from Student s " + "join fetch s.courses " + "where s.id=:data", Student::class.java
        )
        query.setParameter("data", studentId)

        return query.singleResult
    }

    @Transactional
    override fun update(student: Student) {
        entityManager.merge(student)
    }
}

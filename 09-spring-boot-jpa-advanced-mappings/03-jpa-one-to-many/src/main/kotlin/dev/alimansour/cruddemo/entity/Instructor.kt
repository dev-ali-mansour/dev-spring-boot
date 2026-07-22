package dev.alimansour.cruddemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "instructor")
class Instructor(
    @Column(name = "first_name")
    var firstName: String,
    @Column(name = "last_name")
    var lastName: String,
    @Column(name = "email")
    var email: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "instructor_detail_id")
    var instructorDetail: InstructorDetail? = null

    @OneToMany(
        mappedBy = "instructor",
        fetch = FetchType.EAGER,
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH]
    )
    val courses: MutableList<Course> = mutableListOf()

    override fun toString(): String {
        return "Instructor{" +
                "id: $id, " +
                "firstName: $firstName, " +
                "lastName: $lastName, " +
                "email: $email, " +
                "instructorDetail: $instructorDetail" +
                "}"
    }

    fun add(course: Course) {
        courses.add(course)
        course.instructor = this
    }
}

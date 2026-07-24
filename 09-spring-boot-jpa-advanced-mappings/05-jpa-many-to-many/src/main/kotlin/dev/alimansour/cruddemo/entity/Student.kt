package dev.alimansour.cruddemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
class Student(
    @Column(name = "first_name")
    var firstName: String = "",
    @Column(name = "last_name")
    var lastName: String = "",
    @Column(name = "email")
    var email: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH]
    )
    @JoinTable(
        name = "course_student",
        joinColumns = [JoinColumn(name = "student_id")],
        inverseJoinColumns = [JoinColumn(name = "course_id")]
    )
    var courses: MutableList<Course> = mutableListOf()

    fun addCourse(course: Course) {
        courses.add(course)
    }

    override fun toString(): String {
        return "Student{id=$id, firstName='$firstName', lastName='$lastName', email='$email'}"
    }
}

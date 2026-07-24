package dev.alimansour.cruddemo.entity


import jakarta.persistence.*

@Entity
@Table(name = "course")
class Course(
    @Column(name = "title")
    var title: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH])
    @JoinColumn(name = "instructor_id")
    var instructor: Instructor? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "course_id")
    var reviews: MutableList<Review> = mutableListOf()

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH],
    )
    @JoinTable(
        name = "course_student",
        joinColumns = [JoinColumn(name = "course_id")],
        inverseJoinColumns = [JoinColumn(name = "student_id")]
    )
    var students: MutableList<Student> = mutableListOf()

    fun add(review: Review) {
        reviews.add(review)
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    override fun toString(): String {
        return "Course{id=$id, title='$title'}"
    }
}

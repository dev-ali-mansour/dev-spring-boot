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

    override fun toString(): String {
        return "Course{id=$id, title='$title'}"
    }
}

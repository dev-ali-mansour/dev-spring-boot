package dev.alimansour.cruddemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "instructor_detail")
class InstructorDetail(
    @Column(name = "youtube_channel")
    var youtubeChannel: String = "",
    @Column(name = "hobby")
    var hobby: String = "",
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    @OneToOne(
        mappedBy = "instructorDetail",
        cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH]
    )
    var instructor: Instructor? = null

    override fun toString(): String {
        return "InstructorDetail{id=$id, youtubeChannel='$youtubeChannel', hobby='$hobby'}"
    }
}

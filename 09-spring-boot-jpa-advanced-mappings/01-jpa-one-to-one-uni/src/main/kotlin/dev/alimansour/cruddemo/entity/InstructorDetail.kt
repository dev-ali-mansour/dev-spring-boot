package dev.alimansour.cruddemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "instructor_detail")
class InstructorDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0,
    @Column(name = "youtube_channel")
    var youtubeChannel: String = "",
    @Column(name = "hobby")
    var hobby: String = "",
) {
    override fun toString(): String {
        return "InstructionDetail{id=$id, youtubeChannel='$youtubeChannel', hobby='$hobby'}"
    }
}

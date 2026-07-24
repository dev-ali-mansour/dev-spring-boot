package dev.alimansour.cruddemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "review")
class Review(
    @Column(name = "comment")
    var comment: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0

    override fun toString(): String {
        return "Review{id=$id, comment='$comment'}"
    }
}

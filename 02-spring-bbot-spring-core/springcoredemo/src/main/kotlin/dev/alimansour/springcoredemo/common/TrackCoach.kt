package dev.alimansour.springcoredemo.common

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary
class TrackCoach : Coach {
    override fun getDailyWorkout(): String {
        return "Run a hard 5k!"
    }
}
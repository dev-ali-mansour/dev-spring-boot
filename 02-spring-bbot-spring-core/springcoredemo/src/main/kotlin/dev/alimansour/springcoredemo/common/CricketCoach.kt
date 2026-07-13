package dev.alimansour.springcoredemo.common

import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Component
@Lazy
class CricketCoach : Coach {
    init {
        println("In constructor: ${javaClass.simpleName}")
    }

    override fun getDailyWorkout(): String {
        return "Practice fast bowling for 15 minutes"
    }
}

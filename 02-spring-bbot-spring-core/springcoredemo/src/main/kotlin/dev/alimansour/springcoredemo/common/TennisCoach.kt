package dev.alimansour.springcoredemo.common

import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Component
@Lazy
class TennisCoach: Coach {
    init {
        println("In constructor: ${javaClass.simpleName}")
    }

    override fun getDailyWorkout(): String {
        return "Practice your backhand volley"
    }
}

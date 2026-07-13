package dev.alimansour.springcoredemo.common

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.stereotype.Component

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CricketCoach : Coach {
    init {
        println("In constructor: ${javaClass.simpleName}")
    }

    // define our initializing method
    @PostConstruct
    fun doMyStartupStaff() {
        println("In doMyStartupStuff(): ${javaClass.simpleName}")
    }

    // define our destroy method
    @PreDestroy
    fun doMyCleanupStuff() {
        println("In doMyCleanupStuff(): ${javaClass.simpleName}")
    }

    override fun getDailyWorkout(): String {
        return "Practice fast bowling for 15 minutes"
    }
}

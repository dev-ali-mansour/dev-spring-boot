package dev.alimansour.springcoredemo.rest

import dev.alimansour.springcoredemo.common.Coach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController

class DemoController @Autowired constructor(private val coach: Coach) {

    /*
    // Setter Injection
    @Autowired
    private lateinit var coach: Coach

    @Autowired
    fun setCoach2(coach: Coach) {
        this.coach = coach
    }
    */

    /*
    // Field Injection
    @Autowired
    private lateinit var coach: Coach
    */

    @GetMapping("/dailyworkout")
    fun getDailyWorkout(): String {
        return coach.getDailyWorkout()
    }
}
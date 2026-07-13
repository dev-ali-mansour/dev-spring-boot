package dev.alimansour.springcoredemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController

class DemoController @Autowired constructor(private val coach: Coach) {
    @GetMapping("/dailyworkout")
    fun getDailyWorkout(): String {
        return coach.getDailyWorkout()
    }
}

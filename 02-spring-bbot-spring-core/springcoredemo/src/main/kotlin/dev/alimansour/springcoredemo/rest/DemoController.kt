package dev.alimansour.springcoredemo.rest

import dev.alimansour.springcoredemo.common.Coach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController

class DemoController @Autowired constructor(
    @Qualifier("aquatic") private val coach: Coach,
//    @Qualifier("cricketCoach") private val anotherCoach: Coach,
) {

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
    // Not Recommended by the spring.io development team
    // because it makes the code harder to unit test
    @Autowired
    private lateinit var coach: Coach
    */

    init {
        println("In constructor: ${javaClass.simpleName}")
    }

    @GetMapping("/dailyworkout")
    fun getDailyWorkout(): String {
        return coach.getDailyWorkout()
    }

    /*@GetMapping("/check")
    fun check(): String {
        return "Comparing beans: myCoach == anotherCoach, ${coach == anotherCoach}"
    }*/
}

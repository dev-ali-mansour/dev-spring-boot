package dev.alimansour.springboot.demo.mycoolapp.rest

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FunRestController {
    // inject properties for: coach.name and team.name
    @Value("\${coach.name}")
    private lateinit var coachName: String

    @Value("\${team.name}")
    private lateinit var teamName: String

    //expose new endpoints for "teaminfo"
    @GetMapping("/teaminfo")
    fun getTeamInfo(): String {
        return "Coach: $coachName, Team name: $teamName"
    }

    // expose "/" that return "Hello World

    @GetMapping("/")
    fun sayHello(): String {
        return "Hello World!"
    }

    @GetMapping("/workout")
    fun getDailyWorkout(): String {
        return "Run a hard 5k!"
    }

    @GetMapping("/fortune")
    fun getDailyFortune(): String {
        return "Today is your lucky day."
    }

}
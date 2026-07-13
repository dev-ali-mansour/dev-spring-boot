package dev.alimansour.springcoredemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringcoredemoApplication

fun main(args: Array<String>) {
    runApplication<SpringcoredemoApplication>(*args)
}

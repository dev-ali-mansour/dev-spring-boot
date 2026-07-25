package dev.alimansour.aopdemo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class AopdemoApplication {
    @Bean
    fun commandLineRunner(): CommandLineRunner {
        return CommandLineRunner {
			println("Hello World!")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<AopdemoApplication>(*args)
}

package dev.alimansour.springcoredemo.config

import dev.alimansour.springcoredemo.common.Coach
import dev.alimansour.springcoredemo.common.SwimCoach
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SportConfig {
    @Bean("aquatic")
    fun swimCoach(): Coach {
        return SwimCoach()
    }
}
package dev.alimansour.springdemo.mvc

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

class Customer(
    val firstName: String = "",
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    val lastName: String = "",
)

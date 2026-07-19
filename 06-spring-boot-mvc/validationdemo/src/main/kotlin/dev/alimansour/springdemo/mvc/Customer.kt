package dev.alimansour.springdemo.mvc

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

class Customer(
    val firstName: String = "",
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    val lastName: String = "",
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    val freePasses: Int? = null,
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    val postalCode: String = "",
)

package dev.alimansour.demo.rest

data class StudentErrorResponse(
    val status: Int,
    val message: String,
    val timeStamp: Long,
)

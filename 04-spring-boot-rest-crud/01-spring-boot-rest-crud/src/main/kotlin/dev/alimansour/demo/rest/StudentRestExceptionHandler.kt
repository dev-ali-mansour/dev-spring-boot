package dev.alimansour.demo.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class StudentRestExceptionHandler {

    // add exception handling code here

    @ExceptionHandler
    fun handleException(exc: StudentNotFoundException): ResponseEntity<StudentErrorResponse> {

        // create StudentErrorResponse

        val error = StudentErrorResponse(
            status = HttpStatus.NOT_FOUND.value(),
            message = exc.message.orEmpty(),
            timeStamp = System.currentTimeMillis()
        )

        // return ResponseEntity

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    // add another exception handler ... to catch any exception (catch all)

    @ExceptionHandler
    fun handleException(exc: Exception): ResponseEntity<StudentErrorResponse> {

        // create StudentErrorResponse

        val error = StudentErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            message = exc.message.orEmpty(),
            timeStamp = System.currentTimeMillis()
        )

        // return ResponseEntity

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}

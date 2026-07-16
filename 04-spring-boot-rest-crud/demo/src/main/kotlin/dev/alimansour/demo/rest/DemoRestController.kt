package dev.alimansour.demo.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class DemoRestController {

    // add code for the /hello endpoint

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello World!"
    }
}

package dev.alimansour.springboot.thymeleafdemo.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloWorldController {
    @GetMapping("/showForm")
    fun showForm(): String {
        return "helloworld-form"
    }

    @GetMapping("/processForm")
    fun processForm(): String {
        return "helloworld"
    }

    @GetMapping("processFormVersionTwo")
    fun letsShoutDude(request: HttpServletRequest, model: Model): String {
        var name = request.getParameter("studentName")
        name = name.uppercase()

        val result = "Yo! $name"

        model.addAttribute("message", result)

        return "helloworld"
    }

    @GetMapping("processFormVersionThree")
    fun processFromVersionThree(
        @RequestParam("studentName") name: String,
        model: Model
    ): String {

        val result = "Hey My Friend From v3! ${name.uppercase()}"

        model.addAttribute("message", result)

        return "helloworld"
    }
}

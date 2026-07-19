package dev.alimansour.springdemo.mvc

import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class CustomerController {
    @GetMapping("/")
    fun showForm(model: Model): String {
        model.addAttribute("customer", Customer())
        return "customer-form"
    }

    @PostMapping("/processForm")
    fun processForm(
        @Valid @ModelAttribute("customer") customer: Customer,
        bindingResult: BindingResult,
    ): String {
        if (bindingResult.hasErrors()) {
            return "customer-form"
        } else {
            return "customer-confirmation"
        }
    }
}

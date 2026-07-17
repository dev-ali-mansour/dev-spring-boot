package dev.alimansour.springboot.cruddemo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class DemoSecurityConfig {
    @Bean
    fun userDetailsManager(): UserDetailsManager {
        val john = User.builder()
            .username("john")
            .password("{noop}test123")
            .roles("EMPLOYEE")
            .build()
        val mary = User.builder()
            .username("mary")
            .password("{noop}test123")
            .roles("EMPLOYEE", "MANAGER")
            .build()
        val susan = User.builder()
            .username("susan")
            .password("{noop}test123")
            .roles("EMPLOYEE", "MANAGER", "ADMIN")
            .build()

        return InMemoryUserDetailsManager(john, mary, susan)
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authRequest ->
            authRequest.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
            authRequest.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
            authRequest.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
            authRequest.requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
            authRequest.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        }

        // use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults())

        // disable Cross Site Request Forgery (CSRF)
        // in general, it is not required for stateless REST APIS that use PUST, PUT, DELETE, and /or PATCH
        http.csrf { csrf -> csrf.disable() }

        return http.build()
    }

}

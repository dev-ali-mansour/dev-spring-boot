package dev.alimansour.springboot.demosecurity.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class DemoSecurityConfig {
    @Bean
    fun userDetailsManager(): InMemoryUserDetailsManager {
        val john: UserDetails = User.builder()
            .username("john")
            .password("{noop}test123")
            .roles("EMPLOYEE")
            .build()
        val mary: UserDetails = User.builder()
            .username("mary")
            .password("{noop}test123")
            .roles("EMPLOYEE", "MANAGER")
            .build()
        val susan: UserDetails = User.builder()
            .username("susan")
            .password("{noop}test123")
            .roles("EMPLOYEE", "MANAGER", "ADMIN")
            .build()

        return InMemoryUserDetailsManager(john, mary, susan)
    }

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { authRequest ->
            authRequest
                .anyRequest().authenticated()
        }.formLogin { form ->
            form
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
        }

        return http.build()
    }
}

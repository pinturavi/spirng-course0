package com.example.course0

import com.example.course0.filtering.Student
import com.example.course0.user.Post
import com.example.course0.user.PostJpaRepository
import com.example.course0.user.User
import com.example.course0.user.UserJpaRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.time.LocalDate
import java.util.*

@SpringBootApplication
class Course0Application {

    @Bean
    fun commandLineRunner(ur: UserJpaRepository, pr: PostJpaRepository) = CommandLineRunner {
        val ravi = User(name = "ravi", dob = LocalDate.of(1993, 12, 3))
        val pintu = User(name = "pintu", dob = LocalDate.of(1993, 12, 3))
        val vijay = User(name = "vijay", dob = LocalDate.of(1993, 12, 3))
        ur.saveAll(
                listOf(
                        ravi, pintu, vijay
                )
        )

        pr.saveAll(
                listOf(Post(description = "post1", user = ravi), Post(description = "post2", user = pintu), Post(description = "post3", user = vijay))
        )

    }

    @Bean
    fun localeResolver(): LocaleResolver {
        val localeResolver = AcceptHeaderLocaleResolver()
        localeResolver.setDefaultLocale(Locale.US)
        return localeResolver
    }

}

fun main(args: Array<String>) {
    runApplication<Course0Application>(*args)
}

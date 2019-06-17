package com.example.course0

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContext
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class HelloWorldController(val messageSource: MessageSource) {

    @GetMapping("/hello")
    fun sayHello() = LocaleContextHolder.getLocale().let { this.messageSource.getMessage("greet.message", null, it) }
}
package com.example.course0

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {
    private val DEFAULT_CONSUMES_PRODUCES: MutableSet<String>?=hashSetOf("application/json", "applicatin/xml")
    val DEFAULT_CONTACT = Contact("ravi", "www.pinturavi.com", "ravi.s18@hotmail.com")
    val DEFAULT_API_INFO = ApiInfo("Awesome Description", "Awesome Documentation", "1.0", "urn:tos",
            DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0")

    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .apiInfo(DEFAULT_API_INFO)
            .produces(DEFAULT_CONSUMES_PRODUCES)
            .consumes(DEFAULT_CONSUMES_PRODUCES)
}
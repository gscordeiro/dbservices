package dev.gscordeiro.dbservices

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class HelloController {

    @GetMapping
    fun helloSpring(): String {

        println("Hello Spring Boot + Kotlin > " + Instant.now())

        return "Hello Spring Boot + Kotlin";

    }
}
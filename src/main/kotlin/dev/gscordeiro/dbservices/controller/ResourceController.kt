package dev.gscordeiro.dbservices.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/resources")
class ResourceController(
//    private val resourceService: ResourceService
) {

    @GetMapping("/{name}")
    fun executar(
        @PathVariable name: String,
        authentication: Authentication,        // equivalent to CDI @Context SecurityContext sc
        request: HttpServletRequest            // equivalent to CDI @Context UriInfo userInfo
    ): ResponseEntity<Any> {

        val username = authentication.name
        val roles = authentication.authorities.map { it.authority }
        val queryParams = request.parameterMap  // equivalent to CDI userInfo.getQueryParameters()
        val requestUri = request.requestURI

//        val result = resourceService.execute(name, username, queryParams)
//        return ResponseEntity.ok(result)

        val result = mapOf(
            "username" to username,
            "roles" to roles,
            "queryParams" to queryParams,
            "requestUri" to requestUri
        )

        println(result)

        return ResponseEntity.ok(result)
    }

    @GetMapping("/hello")
    fun hello() = "Hello World!"
}
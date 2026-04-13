package dev.gscordeiro.dbservices.controller

import dev.gscordeiro.dbservices.entity.User
import dev.gscordeiro.dbservices.service.UserService
import jakarta.annotation.PostConstruct
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/users"])
class UserController(
    private val userService: UserService
) {

    @PostConstruct
    fun init() {
        userService.initializeData()
    }

    @GetMapping("/all")
    fun list(): List<User> {
        return userService.list()
    }

    @GetMapping("/update/{userId}")
    fun update(@PathVariable userId: Long, username: String): ResponseEntity<User> {
        val user = userService.findById(userId)
        user?.let { user ->
            user.username = username
            return ResponseEntity.ok(userService.update(user))
        }
        return ResponseEntity.notFound().build()
    }
}

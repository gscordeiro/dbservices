package dev.gscordeiro.dbservices.service

import dev.gscordeiro.dbservices.entity.Role
import dev.gscordeiro.dbservices.entity.User
import dev.gscordeiro.dbservices.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class UserService(
    val userRepository: UserRepository,
    val encoder: PasswordEncoder
) {

    @Transactional
    fun initializeData() {
        val roleUser = Role(name = "USER")
        val roleAdmin = Role(name = "ADM")

        val defaultPass = encoder.encode("123456") ?: "123456"

        saveUser(User(username = "emily", password = defaultPass, roles = mutableListOf(roleUser, roleAdmin)))
        saveUser(User(username = "emma", password = defaultPass, roles = mutableListOf(roleUser)))
        saveUser(User(username = "james", password = defaultPass, roles = mutableListOf(roleUser, roleAdmin)))
        saveUser(User(username = "john", password = defaultPass, roles = mutableListOf(roleUser)))
    }

    fun saveUser(user: User): User {
        return userRepository.save(user)
    }

    fun list(): List<User> {
        return userRepository.findAll()
    }

    fun update(user: User): User {
        return userRepository.save(user)
    }

    fun findById(id: Long): User? {
        return userRepository.findById(id).getOrNull()
    }
}

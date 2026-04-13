package dev.gscordeiro.dbservices.service

import dev.gscordeiro.dbservices.entity.Role
import dev.gscordeiro.dbservices.entity.User
import dev.gscordeiro.dbservices.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Service
class UserService(
    val userRepository: UserRepository
) {

    @Transactional
    fun initializeData() {
        val roleUser = Role(name = "USER")
        val roleAdmin = Role(name = "ADM")

        saveUser(User(username = "Emily", roles = mutableListOf(roleUser, roleAdmin)))
        saveUser(User(username = "Emma", roles = mutableListOf(roleUser)))
        saveUser(User(username = "James", roles = mutableListOf(roleUser, roleAdmin)))
        saveUser(User(username = "John", roles = mutableListOf(roleUser)))
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

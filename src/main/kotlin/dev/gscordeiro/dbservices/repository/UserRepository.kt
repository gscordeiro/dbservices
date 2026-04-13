package dev.gscordeiro.dbservices.repository

import dev.gscordeiro.dbservices.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
}

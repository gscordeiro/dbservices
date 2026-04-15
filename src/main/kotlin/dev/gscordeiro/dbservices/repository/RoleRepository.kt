package dev.gscordeiro.dbservices.repository

import dev.gscordeiro.dbservices.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findAllByNameIn(nomes: List<String>): List<Role>
}
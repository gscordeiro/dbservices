package dev.gscordeiro.dbservices.service

import dev.gscordeiro.dbservices.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User as UserDetailsImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User '$username' not found")

        val authorities = user.roles.map { SimpleGrantedAuthority(it.name) }

        return UserDetailsImpl(
            user.username,
            user.password,
            user.enabled,
            true, true, true,
            authorities
        )
    }
}
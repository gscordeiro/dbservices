package dev.gscordeiro.dbservices.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "roles")
class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Role) return false

        // If both ids are null, they are not equal (distinct transient entities)
        // If one id is null and the other is not, they are not equal
        if (id == null || other.id == null) return false

        return id == other.id
    }

    override fun hashCode(): Int {
        // Explicitly uses Role class hash, ensuring consistency between proxies and real entity
        return Role::class.java.hashCode()
    }

    override fun toString(): String {
        return "Role(id=$id, name=$name)"
    }
}

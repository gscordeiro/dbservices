package dev.gscordeiro.dbservices.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "data_sources")
class DataSource(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var name: String = "",

    @Column(nullable = false)
    var url: String = "",

    @Column(nullable = false)
    var username: String? = null,

    @Column(nullable = false)
    var password: String? = null
){
    override fun toString(): String {
        return "DataSource(id=$id, name=$name, url=$url, username=$username, password=$password)"
    }

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id == null || other.id == null) return false

        return id == other.id
    }

    final override fun hashCode(): Int = DataSource::class.java.hashCode()

}
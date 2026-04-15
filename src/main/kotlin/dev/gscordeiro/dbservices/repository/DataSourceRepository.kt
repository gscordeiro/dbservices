package dev.gscordeiro.dbservices.repository

import dev.gscordeiro.dbservices.entity.DataSource
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DataSourceRepository : JpaRepository<DataSource, Long>
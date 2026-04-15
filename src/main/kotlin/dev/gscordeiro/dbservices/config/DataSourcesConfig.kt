package dev.gscordeiro.dbservices.config

import dev.gscordeiro.dbservices.entity.DataSource
import dev.gscordeiro.dbservices.repository.DataSourceRepository
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource as JdbcDataSource

@Configuration
class DataSourcesConfig(
    private val dataSourceRepository: DataSourceRepository
) {

    @Bean
    fun dataSourceMap(): Map<String, JdbcDataSource> =
        dataSourceRepository.findAll().associate { config ->
            config.name to buildDataSource(config)
        }

    private fun buildDataSource(config: DataSource): JdbcDataSource =
        DataSourceBuilder.create()
            .url(config.url)
            .username(config.username)
            .password(config.password)
            .build()
}
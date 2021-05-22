package net.siegerpg.siege.core.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import net.siegerpg.siege.core.Core
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.sql.Connection
import java.sql.SQLException

object DatabaseManager {

    private var url: String = ""
    private var user: String = ""
    private var password: String = ""

    private val config = HikariConfig()
    private val ds: HikariDataSource

    init {

        val configFile = File(Core.plugin().dataFolder.absolutePath, "privKeys.yml")
        if (!configFile.exists()) {
            Core.plugin().logger.severe("privKeys.yml not found")
        }
        val configuration: YamlConfiguration = YamlConfiguration.loadConfiguration(configFile)
        url = String.format(
            "jdbc:mysql://%s/%s",
            configuration.getString("db.endpoint"),
            configuration.getString("db.dbname")
        )
        configuration.getString("db.username")?.let { user = it }
        configuration.getString("db.password")?.let { password = it }
        config.jdbcUrl = url
        config.username = user
        config.password = password
        config.addDataSourceProperty("cachePrepStmts", "true")
        config.addDataSourceProperty("prepStmtCacheSize", "250")
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")
        config.leakDetectionThreshold = 30000;
        ds = HikariDataSource(config)
    }

    @Throws(SQLException::class)
    fun getConnection(): Connection? {
        return ds.connection
    }
}
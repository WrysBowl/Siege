package net.siegerpg.siege.core.database

import io.lumine.xikage.mythicmobs.utils.storage.sql.hikari.HikariConfig
import io.lumine.xikage.mythicmobs.utils.storage.sql.hikari.HikariDataSource
import net.siegerpg.siege.core.Core
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.sql.SQLException
import java.sql.Connection

object DatabaseManager {

    var url: String = ""
    var user: String = ""
    var password: String = ""

    private val config = HikariConfig()
    private val ds: HikariDataSource

    init {
        val configFile = File(Core.INSTANCE.getDataFolder().getAbsolutePath(), "privKeys.yml")
        if (!configFile.exists()) {
            Core.INSTANCE.getLogger().severe("privKeys.yml not found")
        }
        val configuration: YamlConfiguration = YamlConfiguration.loadConfiguration(configFile)
        url = String.format(
            "jdbc:mysql://%s/%s",
            configuration.getString("db.endpoint"),
            configuration.getString("db.db name")
        )
        configuration.getString("db.username")?.let { user = it }
        configuration.getString("db.password")?.let { password = it }
        config.setJdbcUrl(url)
        config.setUsername(user)
        config.setPassword(password)
        config.addDataSourceProperty("cachePrepStmts", "true")
        config.addDataSourceProperty("prepStmtCacheSize", "250")
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")
        ds = HikariDataSource(config)
    }

    @Throws(SQLException::class)
    fun getConnection(): Connection? {
        return ds.connection
    }
}
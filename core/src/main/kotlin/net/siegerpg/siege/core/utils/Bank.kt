package net.siegerpg.siege.core.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.siegerpg.siege.core.database.DatabaseManager
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.sql.ResultSet

object Bank {

    fun getBankLevel(player: OfflinePlayer): Short {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                "SELECT bankLvl FROM userData WHERE uuid=?",
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            stmt.setString(1, player.uniqueId.toString())
            val query = stmt.executeQuery();
            if (!query.isBeforeFirst) return 0
            query.next()
            return query.getShort("bankLvl")
        }
    }

    fun getBankAmount(player: OfflinePlayer): Int {
        val connection = DatabaseManager.getConnection()
        connection!!.use {
            val stmt = connection.prepareStatement(
                "SELECT bankAmt FROM userData WHERE uuid=?",
                ResultSet.TYPE_SCROLL_SENSITIVE
            )
            stmt.setString(1, player.uniqueId.toString())
            val query = stmt.executeQuery();
            if (!query.isBeforeFirst) return 0
            query.next()
            return query.getInt("bankAmt")
        }
    }

    fun setBankLevel(player: OfflinePlayer, level: Short) {
        GlobalScope.launch(Dispatchers.IO) {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement("UPDATE userData SET bankLvl=? WHERE uuid=?");
                stmt.setShort(1, level)
                stmt.setString(2, player.uniqueId.toString())
                stmt.executeUpdate()
            }
        }
    }

    fun setBankAmount(player: OfflinePlayer, amount: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            val connection = DatabaseManager.getConnection()
            connection!!.use {
                val stmt = connection.prepareStatement("UPDATE userData SET bankAmt=? WHERE uuid=?");
                stmt.setInt(1, amount)
                stmt.setString(2, player.uniqueId.toString())
                stmt.executeUpdate()
            }
        }
    }

}
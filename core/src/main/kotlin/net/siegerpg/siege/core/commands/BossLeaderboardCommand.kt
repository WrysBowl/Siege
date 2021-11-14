package net.siegerpg.siege.core.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.CommandCompletions
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandCompletion
import co.aikar.commands.annotation.Subcommand
import co.aikar.commands.annotation.Syntax
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.dungeons.DungeonCommand
import net.siegerpg.siege.core.utils.BossLeaderboardDB
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.time.Duration


@CommandAlias("bossleaderboard|bosslb|blb")
class BossLeaderboardCommand : BaseCommand() {
    init {
        Core.plugin().commandManager.commandCompletions.registerCompletion(
            "bosses",
            CommandCompletions.CommandCompletionHandler {
                return@CommandCompletionHandler DungeonCommand.dungeons.keys
            })
    }

    @Subcommand("boss")
    @CommandCompletion("@bosses")
    @Syntax("<boss>")
    fun bossData(player: Player, boss: String) {
        player.sendMessage(Utils.parse("<gray>Fetching data...."))
        BossLeaderboardDB.getBossLeaderboardTop10Data(boss) { data ->
            if (data == null) {
                player.sendMessage(Utils.parse("<red>No data exists for this boss!"))
                return@getBossLeaderboardTop10Data
            }
            player.sendMessage(Utils.parse("<gold>---- <gray>$boss <gold>----"))
            data.forEachIndexed { index, (uuid, data) ->
                val duration = Duration.ofSeconds(data.second.toLong())
                val HH = duration.toHours()
                val MM = duration.toMinutesPart().toLong()
                val SS = duration.toSecondsPart().toLong()
                val timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS)
                val lbPlayer = Bukkit.getOfflinePlayer(uuid)
                player.sendMessage(Utils.parse("<gold>${index + 1}. <gray>${lbPlayer.name}: <gold>${data.first}% <gray>(in <gold>${timeInHHMMSS} <gray>)"))
            }
            player.sendMessage(Utils.parse("<gold>------------"))
        }
    }


}
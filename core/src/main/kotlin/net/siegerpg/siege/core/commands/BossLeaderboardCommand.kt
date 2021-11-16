package net.siegerpg.siege.core.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.CommandCompletions
import co.aikar.commands.annotation.*
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.dungeons.DungeonCommand
import net.siegerpg.siege.core.events.BossLeaderboard
import net.siegerpg.siege.core.miscellaneous.BossLeaderboardDB
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.time.Instant


@CommandAlias("bossleaderboard|bosslb|blb")
class BossLeaderboardCommand : BaseCommand() {

	init {
		Core.plugin().commandManager.commandCompletions.registerCompletion(
				"bosses",
				CommandCompletions.CommandCompletionHandler {
					return@CommandCompletionHandler DungeonCommand.dungeons.keys
				})
	}


	@Subcommand("top10")
	@CommandCompletion("@bosses")
	@Syntax("<boss>")
	fun bossTop10Data(player : Player, boss : String) {
		player.sendMessage(Utils.parse("<gray>Fetching data...."))
		BossLeaderboardDB.getBossLeaderboardTop10Data(boss) { data ->
			if (data == null) {
				player.sendMessage(Utils.parse("<red>No data exists for this boss!"))
				return@getBossLeaderboardTop10Data
			}
			player.sendMessage(Utils.parse("<gold>---- <gray>$boss <gold>----"))
			data.forEachIndexed { index, (uuid, data) ->
				val timeInHHMMSS = Utils.secondsToHHMMSS(data.second.toLong())
				val lbPlayer = Bukkit.getOfflinePlayer(uuid)
				player.sendMessage(Utils.parse("<gold>${index + 1}. <gray>${lbPlayer.name}: <gold>${data.first}% <gray>(in <gold>${timeInHHMMSS} <gray>)"))
			}
			player.sendMessage(Utils.parse("<gold>------------"))
		}
	}

	@Subcommand("me")
	@CommandCompletion("@bosses")
	@Syntax("<boss>")
	fun bossDataMe(player : Player, boss : String) {
		player.sendMessage(Utils.parse("<gray>Fetching data...."))
		BossLeaderboardDB.getBossLeaderboardData(player.uniqueId, boss) { data ->
			if (data == null) {
				player.sendMessage(Utils.parse("<red>No data exists for this boss (or you)!"))
				return@getBossLeaderboardData
			}
			player.sendMessage(Utils.parse("<gold>---- <gray>Your stats for <gold>$boss<gray>! <gold>----"))
			player.sendMessage("<gray>Damage dealt: <gold>${data.first}%")
			val timeInHHMMSS = Utils.secondsToHHMMSS(data.second.toLong())
			player.sendMessage(Utils.parse("<gray>Time taken: <gold>${timeInHHMMSS}<gray>."))
			player.sendMessage(Utils.parse("<gold>------------"))
		}
	}

	@Subcommand("stats")
	@CommandCompletion("* @bosses")
	@Syntax("<player> <boss>")
	fun bossDataPlayer(player : Player, otherPlayer : OfflinePlayer, boss : String) {
		player.sendMessage(Utils.parse("<gray>Fetching data...."))
		BossLeaderboardDB.getBossLeaderboardData(otherPlayer.uniqueId, boss) { data ->
			if (data == null) {
				player.sendMessage(Utils.parse("<red>No data exists for this boss (or ${otherPlayer.name})!"))
				return@getBossLeaderboardData
			}
			player.sendMessage(Utils.parse("<gold>---- <gray>${otherPlayer.name}'s stats for <gold>$boss<gray>! <gold>----"))
			player.sendMessage("<gray>Damage dealt: <gold>${data.first}%")
			val timeInHHMMSS = Utils.secondsToHHMMSS(data.second.toLong())
			player.sendMessage(Utils.parse("<gray>Time taken: <gold>${timeInHHMMSS}<gray>."))
			player.sendMessage(Utils.parse("<gold>------------"))
		}
	}

	@Subcommand("holo|hologram")
	@CommandPermission("op")
	public class Holo : BaseCommand() {

		@Subcommand("spawn|add|create")
		@CommandCompletion("@bosses")
		@Syntax("<boss>")
		public fun spawn(p : Player, boss : String) {
			val hologram = HologramsAPI.createHologram(Core.plugin(), p.location)
			BossLeaderboard.updateHologram(hologram, boss)
		}

		@Subcommand("list|l")
		@CommandCompletion("@bosses")
		@Syntax("<boss>")
		public fun list(p : Player, boss : String) {
			val holograms = BossLeaderboard.getBossHolograms(boss)
			p.sendMessage(Utils.parse("<gold>---- <gray>$boss <gold>----"))
			holograms.forEachIndexed { i, holo ->
				p.sendMessage(
						Utils.parse(
								"<hover:show_text:'<gray>Position: <gold>${holo.location}\n<gray>Created at: <gold>${
									Instant.ofEpochMilli(
											holo.creationTimestamp
									                    )
								}'><gold>Hologram #${i + 1}<gray>"
						           )
				             )
			}
			p.sendMessage(Utils.parse("<gold>----------"))
		}

		@Subcommand("removenear|deletenear")
		@CommandCompletion("@bosses")
		@Syntax("<boss>")
		public fun delete(p : Player, boss : String) {
			val holograms = BossLeaderboard.getBossHolograms(boss)
			val holo = holograms.find { holo ->
				holo.location.distanceSquared(p.location) <= 5
			}
			if (holo == null) {
				p.sendMessage(Utils.parse("<red>No holograms were found within 5 blocks of you."))
				return
			}
			p.sendMessage(Utils.parse("<gray>Successfully deleted a boss hologram!"))
			holo.delete();
		}


		@HelpCommand
		public fun help(player : Player) {
			player.sendMessage(
					listOf(
							"&6 ----- Admin Boss Leaderboard Commands -----",
							"&6/bosslb holo spawn <boss>: &7Spawns a hologram with data for a specific boss at your location.",
							"&6/bosslb holo list <boss>: &7Lists the holograms for a specific boss.",
							"&6/bosslb holo removenear <boss>: &7Removes a boss hologram near (5 blocks around) you.",
					      ).toTypedArray()
			                  )
		}
	}

	@HelpCommand
	fun helpWithBossLeaderboard(player : Player) {
		player.sendMessage(
				listOf(
						"&6 ----- Boss Leaderboard Commands -----",
						"&6/bosslb me <boss>: &7Views your stats for a specific boss.",
						"&6/bosslb top10 <boss>: &7Views the top 10 players for a specific boss.",
						"&6/bosslb stats <player> <boss>: &7Views the boss data for a specific player!",
				      ).toTypedArray()
		                  )
		if (player.isOp) {
			player.sendMessage(
					listOf(
							"&6 ----- Admin Boss Leaderboard Commands -----",
							"&6/bosslb holo spawn <boss>: &7Spawns a hologram with data for a specific boss at your location.",
							"&6/bosslb holo list <boss>: &7Lists the holograms for a specific boss.",
							"&6/bosslb holo removenear <boss>: &7Removes a boss hologram near (5 blocks around) you.",
					      ).toTypedArray()
			                  )
		}
	}


}
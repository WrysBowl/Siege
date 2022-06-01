package net.siegerpg.siege.core.miscellaneous

import com.gmail.filoghost.holographicdisplays.api.Hologram
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI
import com.gmail.filoghost.holographicdisplays.api.line.TextLine
import io.lumine.xikage.mythicmobs.MythicMobs
import io.lumine.xikage.mythicmobs.mobs.ActiveMob
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.drops.MobDropTable
import net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon.*
import net.siegerpg.siege.core.items.CustomItemUtils.getCustomItem
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.cache.ActiveMobs
import net.siegerpg.siege.core.miscellaneous.cache.GlobalMultipliers
import org.bukkit.Bukkit
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.entity.Projectile
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.event.server.PluginDisableEvent
import org.bukkit.inventory.ItemStack
import java.time.Duration
import java.time.Instant
import java.util.*
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.round

data class BossFight(val startTime : Instant, val entity : ActiveMob) {

	val fighters = HashMap<UUID, Double>()
}

object BossLeaderboard {

	fun updateHologram(h : Hologram, bossName : String) {
		BossLeaderboardDB.getBossLeaderboardTop10Data(bossName) { data ->
			updateHologram(h, bossName, data)
		}
	}

	fun updateHologram(
			h : Hologram,
			bossName : String,
			data : List<Pair<UUID, Pair<Byte, Int>>>?
	                  ) {
		Bukkit.getScheduler().runTask(Core.plugin(), Runnable {
			h.clearLines()
			h.appendTextLine(Utils.tacc("&6----- &7$bossName &6-----"))
			if (data == null) {
				h.appendTextLine(Utils.tacc("&cNo data exists for this boss!"))
				return@Runnable
			}
			data.forEachIndexed { index, (uuid, data) ->
				val timeInHHMMSS = Utils.secondsToHHMMSS(data.second.toLong())
				val lbPlayer = Bukkit.getOfflinePlayer(uuid)
				var name = lbPlayer.name
				if (name == null) name = "Unknown"
				h.appendTextLine(Utils.tacc("&6${index + 1}. &7${name}: &6${data.first}% &7(in &6${timeInHHMMSS} &7)"))
			}
			h.appendTextLine(Utils.tacc("&6----------"))
		})
	}

	public fun getBossHolograms(bossName : String) :
			Collection<Hologram> {
		val holograms = HologramsAPI.getHolograms(Core.plugin()).filter { h ->

			(h.size() > 0) && (h.getLine(0) as TextLine).text.lowercase()
					.contains(bossName.lowercase())
		}
		return holograms
	}
}

class BossLeaderboardListener : Listener {




	companion object {
		val dungeonBossDropTableHashMap = mutableMapOf(
				"Broodmother" to Broodmother(),
				"BullSpirit" to BullSpirit(),
				"Davy_Jones" to Davy_Jones(),
				"FoxSpirit" to FoxSpirit(),
				"Lich" to Lich(),
				"MagmaSpirit" to MagmaSpirit(),
				"Necromancer" to Necromancer(),
				"SlimeSpirit" to SlimeSpirit()
		                                              ) as HashMap<String, MobDropTable>
		val currentBossFights = ArrayList<BossFight>()
	}

	//clear all bosses on server restart
	@EventHandler
	fun bossReset(e: PluginDisableEvent) {
		for (fight in currentBossFights) {
			fight.entity.setDead()
		}
		currentBossFights.clear()
	}


	@EventHandler
	public fun onBossGetHit(evt : EntityDamageByEntityEvent) {
		val bossFight =
				currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }
				?: return
		var damager =
				if (evt.damager is Player) evt.damager as Player
				else evt.damager
		if (evt.damager is Projectile) {
			if ((evt.damager as Projectile).shooter is Player) {
				damager = (evt.damager as Projectile).shooter as Player
			}
		}

		if (damager !is Player) return
		val entity = evt.entity as LivingEntity
		val damageDone =
				if (evt.finalDamage > entity.health) entity.health else evt.finalDamage
		bossFight.fighters[damager.uniqueId] =
				(bossFight.fighters[damager.uniqueId] ?: 0.0) + damageDone

	}

	@EventHandler
	public fun onBossUnlive(evt : EntityDeathEvent) {
		val deathTime = Instant.now()
		val bossFight =
				currentBossFights.find { b -> b.entity.uniqueId == evt.entity.uniqueId }
				?: return

		var dropTable : MobDropTable? = null
		val bossName : String;
		if (MythicMobs.inst().apiHelper.isMythicMob(evt.entity)) {
			bossName =
					MythicMobs.inst().apiHelper.getMythicMobInstance(evt.entity).type.internalName
			if (dungeonBossDropTableHashMap.containsKey(bossName)) {
				dropTable = dungeonBossDropTableHashMap[bossName]
			}
		} else {
			bossName = evt.entity.customName ?: evt.entity.name
		}
		val totalDamageDone =
				round(bossFight.fighters.values.reduce { acc, d -> acc + d }).toInt()

		// Uploads data to the db
		val hashMapData = HashMap<UUID, Pair<Byte, Int>>()
		val fightDuration =
				ceil(
						(Duration.between(bossFight.startTime, deathTime).toSeconds().toDouble())
				    )
		bossFight.fighters.forEach { (fighter, damageDone) ->
			var percentageDamage : Int = ceil((damageDone * 100) / totalDamageDone).toInt()
			if (percentageDamage > 100) percentageDamage = 100
			hashMapData[fighter] = Pair(percentageDamage.toByte(), fightDuration.toInt())
			val player : Player = Bukkit.getPlayer(fighter) ?: return

			if (dropTable != null) {

				val dropMultiplier =
						if (percentageDamage >= 50) 1.0 else percentageDamage.toDouble() / 100 * 2

				val time = Utils.secondsToHHMMSS((fightDuration.toInt()).toLong())

				player.sendMessage(Utils.lore(""))
				player.sendMessage(Utils.lore("<green>You dealt <gold>$percentageDamage% <green>of the damage to the boss!"))
				player.sendMessage(Utils.lore("<yellow>Time <gray>$time"))
				player.sendMessage(Utils.lore(""))

				//gets the stacked luck of the mob

				//gets the stacked luck of the mob
				var luck = 0.0
				if (ActiveMobs.luckStacked.containsKey(evt.entity)) {
					luck = ActiveMobs.luckStacked[evt.entity]!!
				}

				var tableExp = dropTable.getExp(true) ?: 0
				if (Math.random() * 100 <= luck) {
					tableExp *= 2
				}
				Levels.addExpShared(
						Bukkit.getOfflinePlayer(fighter),
						floor(tableExp.toDouble() * GlobalMultipliers.getEXPMultipliers(player) * dropMultiplier).toInt()
				                   )

				var tableGoldCoinAmt = dropTable.getGold(true) ?: 0
				if (Math.random() * 100 <= luck) {
					tableGoldCoinAmt *= 2
				}
				val goldCoinAmt =
						floor(tableGoldCoinAmt.toDouble() * GlobalMultipliers.getGoldMultipliers(player) * dropMultiplier).toInt()

				GoldExpListener.giveGold(player, goldCoinAmt)

				for (drop in getRewards(
						(percentageDamage / 100.0),
						dropTable
				                       )) { //Loop through all drops

					val itemList = ArrayList<ItemStack>()
					var i : Double = luck
					while (i >= 0) {
						itemList.add(drop.clone())
						if (i <= 100 && Utils.randTest(i)) {
							itemList.add(drop.clone())
						}
						i -= 100.0
					}

					//gets proper amount of items using luck
					for (items in itemList) {
						DropUtils.dropItemNaturallyForPlayers(
								evt.entity.location,
								items,
								listOf(fighter)
						                                     )
					}

					val customItem = getCustomItem(drop) ?: continue
					if (customItem.quality < 85) continue

					//broadcast 80%+ drops
					val displayName =
							MythicMobs.inst().apiHelper.getMythicMobInstance(evt.entity).displayName
					val miniMessage = Utils.lore(
							"<color:#5DD5B5>" + player.name +
							"<color:#ACD55D> has found a " + drop.itemMeta.displayName +
							" <color:#ACD55D>from a " + displayName
					                            ).hoverEvent(drop)
					Bukkit.broadcast(miniMessage)
				}

			}
		}

		BossLeaderboardDB.setBossData(bossName, hashMapData) {
			BossLeaderboardDB.getBossLeaderboardTop10Data(bossName) { data ->
				BossLeaderboard.getBossHolograms(bossName).forEach { holo ->
					BossLeaderboard.updateHologram(holo, bossName, data)
				}
			}
		}
	}

	private fun getRewards(
			dmgPercent : Double,
			dropTable : MobDropTable
	                      ) : ArrayList<ItemStack> {
		val itemList = ArrayList<ItemStack>()
		for (reward in dropTable.rewards) {
			val chance : Double = (2 * dmgPercent) * reward.chance
			if (Utils.randTest(chance)) {
				itemList.add(reward.item)
			}
		}
		return itemList
	}
}
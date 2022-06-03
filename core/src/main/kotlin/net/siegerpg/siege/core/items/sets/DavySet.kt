package net.siegerpg.siege.core.items.sets

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.implemented.armor.boots.DavyBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.DavyTunic
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.DavyCap
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.DavyLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import org.bukkit.Bukkit
import org.bukkit.entity.EntityType
import org.bukkit.entity.LightningStrike
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.entity.ProjectileLaunchEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable


class DavySet : GearSet(
		helmets = hashSetOf(DavyCap()),
		chestplates = hashSetOf(DavyTunic()),
		leggings = hashSetOf(DavyLeggings()),
		boots = hashSetOf(DavyBoots())
                       ) {

	@EventHandler
	fun onTridentThrow(e: ProjectileLaunchEvent) {
		val trident = e.entity
		if (trident.type != EntityType.TRIDENT) return
		val player = trident.shooter
		if (player !is Player) return

		val list : List<GearSet> = currentSets[player] ?: listOf()
		for (set in list) {
			if (set is DavySet) {
				val lightning = player.getWorld().spawnEntity(trident.getLocation(), EntityType.LIGHTNING)
				(lightning as LightningStrike).flashCount = 40
				trident.addPassenger(lightning)

			}
		}
	}

	override fun setEffect(player : Player) : Boolean{
		if (!super.setEffect(player)) return false

		val gear : GearSet = this
		object : BukkitRunnable() {
			override fun run() {
				val list : List<GearSet> = currentSets[player] ?: listOf()
				if (!list.contains(gear)) {
					this.cancel()
					return
				}

				player.addPotionEffect(
						PotionEffect(
								PotionEffectType.DOLPHINS_GRACE,
								100,
								1,
								false,
								false
						            )
				                      )
				player.addPotionEffect(
						PotionEffect(
								PotionEffectType.SPEED,
								100,
								0,
								false,
								false
						            )
				                      )
				player.addPotionEffect(
						PotionEffect(
								PotionEffectType.WATER_BREATHING,
								100,
								1,
								false,
								false
						            )
				                      )
			}
		}.runTaskTimer(Core.plugin(), 0, 80)
		return true
	}
}
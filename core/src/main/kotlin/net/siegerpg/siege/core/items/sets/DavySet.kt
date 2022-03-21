package net.siegerpg.siege.core.items.sets

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.implemented.armor.boots.LichBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LichCloak
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.LichHood
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.LichLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class DavySet : GearSet(
		helmets = hashSetOf(LichHood()),
		chestplates = hashSetOf(LichCloak()),
		leggings = hashSetOf(LichLeggings()),
		boots = hashSetOf(LichBoots())
                       ) {

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
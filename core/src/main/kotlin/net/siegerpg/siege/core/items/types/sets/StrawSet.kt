package net.siegerpg.siege.core.items.types.sets

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.implemented.armor.boots.StrawBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.strawBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.StrawChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.strawChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.StrawHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.strawHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.StrawLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.strawLeggings.*
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class StrawSet : GearSet(
		helmets = listOf(
				StrawHelmet(), LuckyStrawHat(),
				StrongStrawHat(), ToughStrawHat(),
				HealthyStrawHat(), HealingStrawHat()
		                ),
		chestplates = listOf(
				StrawChestplate(), LuckyStrawChestplate(),
				StrongStrawChestplate(), ToughStrawChestplate(),
				HealthyStrawChestplate(), HealingStrawChestplate()
		                    ),
		leggings = listOf(
				StrawLeggings(), LuckyStrawOveralls(),
				StrongStrawOveralls(), ToughStrawOveralls(),
				HealthyStrawOveralls(), HealingStrawOveralls()
		                 ),
		boots = listOf(
				StrawBoots(), LuckyStrawBoots(),
				StrongStrawBoots(), ToughStrawBoots(),
				HealthyStrawBoots(), HealingStrawBoots()
		              )
                        ) {

	override fun setEffect(player : Player) : Boolean {
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
								PotionEffectType.REGENERATION,
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
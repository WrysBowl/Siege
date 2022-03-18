package net.siegerpg.siege.core.items.sets

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class SlimeSet : GearSet(
		helmets = hashSetOf(
				SlimyHelmet(), LuckySlimyHelmet(),
				StrongSlimyHelmet(), ToughSlimyHelmet(),
				HealthySlimyHelmet(), HealingSlimyHelmet()
		                ),
		chestplates = hashSetOf(
				SlimyChestplate(), LuckySlimyChestplate(),
				StrongSlimyChestplate(), ToughSlimyChestplate(),
				HealthySlimyChestplate(), HealingSlimyChestplate()
		                    ),
		leggings = hashSetOf(
				SlimyLeggings(), LuckySlimyLeggings(),
				StrongSlimyLeggings(), ToughSlimyLeggings(),
				HealthySlimyLeggings(), HealingSlimyLeggings()
		                 ),
		boots = hashSetOf(
				SlimyBoots(), LuckySlimyBoots(),
				StrongSlimyBoots(), ToughSlimyBoots(),
				HealthySlimyBoots(), HealingSlimyBoots()
		              )
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
								PotionEffectType.JUMP,
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
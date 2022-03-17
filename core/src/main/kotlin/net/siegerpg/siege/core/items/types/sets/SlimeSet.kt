package net.siegerpg.siege.core.items.types.sets

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

class SlimeSet : GearSet(
		helmets = listOf(
				SlimyHelmet(), LuckySlimyHelmet(),
				StrongSlimyHelmet(), ToughSlimyHelmet(),
				HealthySlimyHelmet(), HealingSlimyHelmet()
		                ),
		chestplates = listOf(
				SlimyChestplate(), LuckySlimyChestplate(),
				StrongSlimyChestplate(), ToughSlimyChestplate(),
				HealthySlimyChestplate(), HealingSlimyChestplate()
		                    ),
		leggings = listOf(
				SlimyLeggings(), LuckySlimyLeggings(),
				StrongSlimyLeggings(), ToughSlimyLeggings(),
				HealthySlimyLeggings(), HealingSlimyLeggings()
		                 ),
		boots = listOf(
				SlimyBoots(), LuckySlimyBoots(),
				StrongSlimyBoots(), ToughSlimyBoots(),
				HealthySlimyBoots(), HealingSlimyBoots()
		              )
                          ) {

	override fun setEffect(player : Player) {
		super.setEffect(player)
		player.addPotionEffect(PotionEffect(PotionEffectType.JUMP, 999999, 1, false, false))

	}

	override fun removeEffect(player : Player) {
		super.removeEffect(player)
		player.removePotionEffect(PotionEffectType.JUMP)
	}
}
package net.siegerpg.siege.core.items.sets

import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.magmaLeggings.*
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Bukkit
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityDamageByEntityEvent

class MagmaSet : GearSet(
		helmets = hashSetOf(
				MagmaHelmet(), LuckyMagmaHelmet(),
				StrongMagmaHelmet(), ToughMagmaHelmet(),
				HealthyMagmaHelmet(), HealingMagmaHelmet()
		                   ),
		chestplates = hashSetOf(
				MagmaChestplate(), LuckyMagmaChestplate(),
				StrongMagmaChestplate(), ToughMagmaChestplate(),
				HealthyMagmaChestplate(), HealingMagmaChestplate()
		                       ),
		leggings = hashSetOf(
				MagmaLeggings(), LuckyMagmaLeggings(),
				StrongMagmaLeggings(), ToughMagmaLeggings(),
				HealthyMagmaLeggings(), HealingMagmaLeggings()
		                    ),
		boots = hashSetOf(
				MagmaBoots(), LuckyMagmaBoots(),
				StrongMagmaBoots(), ToughMagmaBoots(),
				HealthyMagmaBoots(), HealingMagmaBoots()
		                 )
                        ) {

	@EventHandler(priority = EventPriority.LOW)
	fun onDamage(e : EntityDamageByEntityEvent) {
		if (e.entity !is Player) return
		if (e.damager !is LivingEntity) return
		if (e.isCancelled) return

		val player : Player = e.entity as Player
		val list : List<GearSet> = currentSets[player] ?: listOf()

		if (!Utils.contains(this, list)) return

		if (!Utils.randTest(30.0)) return

		e.damager.fireTicks = 200
	}
}
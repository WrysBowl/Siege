package net.siegerpg.siege.core.items.sets

import io.github.retrooper.packetevents.packettype.PacketType
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.hardenedLeatherBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.hardenedLeatherHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings.*
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.attribute.AttributeInstance
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector

class LeatherSet : GearSet(
		helmets = hashSetOf(
				LeatherHelmet(), LuckyHardenedLeatherHelmet(),
				StrongHardenedLeatherHelmet(), ToughHardenedLeatherHelmet(),
				HealthyHardenedLeatherHelmet(), HealingHardenedLeatherHelmet()
		                   ),
		chestplates = hashSetOf(
				LeatherChestplate(), LuckyHardenedLeatherChestplate(),
				StrongHardenedLeatherChestplate(), ToughHardenedLeatherChestplate(),
				HealthyHardenedLeatherChestplate(), HealingHardenedLeatherChestplate()
		                       ),
		leggings = hashSetOf(
				LeatherLeggings(), LuckyHardenedLeatherLeggings(),
				StrongHardenedLeatherLeggings(), ToughHardenedLeatherLeggings(),
				HealthyHardenedLeatherLeggings(), HealingHardenedLeatherLeggings()
		                    ),
		boots = hashSetOf(
				LeatherBoots(), LuckyHardenedLeatherBoots(),
				StrongHardenedLeatherBoots(), ToughHardenedLeatherBoots(),
				HealthyHardenedLeatherBoots(), HealingHardenedLeatherBoots()
		                 )
                          ) {

	@EventHandler(priority = EventPriority.LOW)
	fun onDamage(e : EntityDamageByEntityEvent) {
		if (e.entity !is Mob) return
		if (e.damager !is Player) return
		if (e.isCancelled) return

		val player : Player = e.damager as Player
		val list : List<GearSet> = currentSets[player] ?: listOf()
		if (!Utils.contains(this, list)) return

		val attribute : AttributeInstance = player.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK) ?: return
		val knockBackValue = attribute.baseValue
		attribute.baseValue = knockBackValue*2

		object : BukkitRunnable() {
			override fun run() {
				attribute.baseValue = knockBackValue
			}

		}.runTaskLater(Core.plugin(), 2)

	}
}
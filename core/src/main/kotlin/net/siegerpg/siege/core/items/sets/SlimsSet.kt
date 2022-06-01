package net.siegerpg.siege.core.items.sets

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimsBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimsChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimsHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimsLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector

class SlimsSet : GearSet(
		helmets = hashSetOf(SlimsHelmet()),
		chestplates = hashSetOf(SlimsChestplate()),
		leggings = hashSetOf(SlimsLeggings()),
		boots = hashSetOf(SlimsBoots())
                        ) {

	@EventHandler(priority = EventPriority.LOW)
	fun onJump(e : PlayerJumpEvent) {
		val player : Player = e.player
		val list : List<GearSet> = currentSets[player] ?: listOf()
		if (!Utils.contains(this, list)) return

		//if player isn't moving (but is jumping)
		if(Math.abs(player.velocity.x) > 0.02 || Math.abs(player.velocity.z) > 0.02) {
			player.velocity = player.location.direction.multiply(0.5)
		}
	}
}
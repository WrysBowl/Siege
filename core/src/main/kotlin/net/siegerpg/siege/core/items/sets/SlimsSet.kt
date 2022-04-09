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

	companion object {
		val cooldown : ArrayList<Player> = arrayListOf()
		val jumpCounter : HashMap<Player, Int> = hashMapOf()
	}

	@EventHandler(priority = EventPriority.LOW)
	fun onJump(e : PlayerJumpEvent) {
		val player : Player = e.player
		if (cooldown.contains(player)) return
		val list : List<GearSet> = currentSets[player] ?: listOf()
		if (!Utils.contains(this, list)) return

		//cooldown for 5 seconds
		cooldown.add(player)
		object : BukkitRunnable() {
			override fun run() {
				cooldown.remove(player)
			}
		}.runTaskLater(Core.plugin(), 160)

		val count = (jumpCounter[player] ?: 0) + 1
		jumpCounter[player] = count
		object : BukkitRunnable() {
			override fun run() {
				jumpCounter[player] = 0
			}
		}.runTaskLater(Core.plugin(), 10)

		//if double jump
		if (count > 1) {
			jumpCounter[player] = 0
			//pushes the player in the direction of the vector
			player.velocity = player.location.direction.setY(0).normalize().multiply(2)
			player.spawnParticle(
					Particle.SMOKE_NORMAL,
					player.location.x,
					player.location.y,
					player.location.z, 20,
					0.0, 0.0, 0.0, 0.2
			                    )
		}
	}
}
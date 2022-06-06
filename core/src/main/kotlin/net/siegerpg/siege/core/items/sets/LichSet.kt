package net.siegerpg.siege.core.items.sets

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
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
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.particleEffects.Waves
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector

class LichSet : GearSet(
		helmets = hashSetOf(LichHood()),
		chestplates = hashSetOf(LichCloak()),
		leggings = hashSetOf(LichLeggings()),
		boots = hashSetOf(LichBoots())
                       ) {

	companion object {

		val cooldown : ArrayList<Player> = arrayListOf()
	}

	@EventHandler
	fun onSneak(e : PlayerToggleSneakEvent) {
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
		}.runTaskLater(Core.plugin(), 100)
		val oldLocation : Location = player.location
		var newLocation : Location = player.location


		/*
		Pre-Teleport
		 */
		oldLocation.world.playSound(player.location, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.2f)
		for(entity in player.location.getNearbyLivingEntities(20.0)) {
			if (entity.equals(player)) continue
			newLocation = entity.location
			break
		}

		//teleports player to the new location
		player.teleport(newLocation)
		for(entity in newLocation.getNearbyLivingEntities(5.0)) {
			if (entity.equals(player)) continue
			entity.damage(CustomItemUtils.getPlayerStat(player, StatTypes.STRENGTH), player)
			break
		}

		object : BukkitRunnable() {
			var counter : Int = 0
			override fun run() {
				counter++

				oldLocation.world.spawnParticle(
						Particle.SOUL,
						player.location.x,
						player.location.y,
						player.location.z, 10,
						0.0, 0.0, 0.0, 0.1)

				if (counter >= 5) {
					this.cancel()
					oldLocation.world.playSound(player.location, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f)
					return
				}

			}
		}.runTaskTimer(Core.plugin(), 0,20)
	}
}
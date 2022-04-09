package net.siegerpg.siege.core.items.sets

import com.destroystokyo.paper.ParticleBuilder
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.implemented.armor.boots.BoomiesHooves
import net.siegerpg.siege.core.items.implemented.armor.boots.BroodMotherClaws
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoomiesChestplate
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BroodMotherCloak
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoomiesHorns
import net.siegerpg.siege.core.items.implemented.armor.helmet.BroodMotherCap
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoomiesLeggings
import net.siegerpg.siege.core.items.implemented.armor.leggings.BroodMotherLegs
import net.siegerpg.siege.core.items.implemented.weapons.wands.BroodMotherWand
import net.siegerpg.siege.core.listeners.WandCast
import net.siegerpg.siege.core.miscellaneous.Utils
import net.siegerpg.siege.core.miscellaneous.particleEffects.Waves
import org.bukkit.*
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.material.MaterialData
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector

class FoxySet : GearSet(
		helmets = hashSetOf(BroodMotherCap()),
		chestplates = hashSetOf(BroodMotherCloak()),
		leggings = hashSetOf(BroodMotherLegs()),
		boots = hashSetOf(BroodMotherClaws())
                       ) {

	companion object {

		val cooldown : ArrayList<Player> = arrayListOf()
		val traps : ArrayList<Location> = arrayListOf()
	}

	@EventHandler
	fun onSneak(e : PlayerToggleSneakEvent) {
		val player : Player = e.player
		if (cooldown.contains(player)) return
		val list : List<GearSet> = currentSets[player] ?: listOf()
		if (!Utils.contains(this, list)) return

		//cooldown for 10 seconds
		cooldown.add(player)
		object : BukkitRunnable() {
			override fun run() {
				cooldown.remove(player)
			}
		}.runTaskLater(Core.plugin(), 200)

		//adds location to trap
		val loc : Location = player.location
		traps.add(loc)

		object : BukkitRunnable() {
			var counter : Int = 0
			override fun run() {
				counter++
				if (counter > 10) {
					loc.world.spawnParticle(
							Particle.FIREWORKS_SPARK,
							loc.x, loc.y, loc.z, 20,
							0.0, 0.0, 0.0, 0.4
					                       )
					this.cancel()
					return
				}
				for (entity in loc.getNearbyLivingEntities(3.0)) {
					if (entity.equals(player)) continue

					//slows enemy that walks over it
					entity.addPotionEffect(
							PotionEffect(
									PotionEffectType.SLOW,
									100,
									9,
									false,
									false
							            )
					                      )
					loc.world.spawnParticle(
							Particle.FIREWORKS_SPARK,
							loc.x, loc.y, loc.z, 20,
							0.0, 0.0, 0.0, 0.4
					                       )
					this.cancel()
					return
				}
				loc.world.spawnParticle(
						Particle.SMOKE_NORMAL,
						loc.x, loc.y, loc.z, 10,
						0.0, 0.0, 0.0, 0.25
				                       )
			}
		}.runTaskTimer(Core.plugin(), 0, 20)
	}
}
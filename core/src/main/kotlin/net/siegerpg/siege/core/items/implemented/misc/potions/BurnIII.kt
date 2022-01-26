package net.siegerpg.siege.core.items.implemented.misc.potions

import io.lumine.xikage.mythicmobs.skills.placeholders.Placeholder.location
import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomPotion
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.World
import org.bukkit.entity.Mob
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionType
import org.bukkit.scheduler.BukkitRunnable
import kotlin.math.cos
import kotlin.math.sin


class BurnIII() : CustomPotion(
		name = "Burn III",
		customModelData = 830008,
		description = listOf("Fire aura deals damage++", "to enemies within 5 blocks"),
		levelRequirement = 0,
		material = Material.POTION,
		potion = PotionType.FIRE_RESISTANCE,
		quality = 90
                              ) {

	override fun speciality(player : Player) {
		var countDown = 120
		object : BukkitRunnable() {
			override fun run() {
				if (countDown <= 0) {
					cancel()
				} else {
					countDown -= 1
					var i = 0.0
					val location : Location = player.location
					val world : World = location.world
					while (i <= Math.PI) {
						val radius = sin(i)
						val y = cos(i)
						var a = 0.0
						while (a < Math.PI * 2) {
							val x = cos(a) * radius
							val z = sin(a) * radius
							location.add(x, y, z)
							// display particle at 'location'
							world.spawnParticle(
									Particle.FLAME.builder()
											.offset(0.0, 0.0, 0.0)
											.particle(), location, 1
							                   )

							location.subtract(x, y, z)
							a += Math.PI / 10
						}
						i += Math.PI / 10
					}
					for (e in player.location.getNearbyLivingEntities(5.0)) {
						if (e !is Mob) continue
						e.fireTicks = 40
						e.damage(12.0, player)
					}
				}
			}
		}.runTaskTimer(Core.plugin(), 20, 20)
	}

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}
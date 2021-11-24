package net.siegerpg.siege.core.items.implemented.misc.potions

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import net.siegerpg.siege.core.items.types.misc.CustomPotion
import net.siegerpg.siege.core.listeners.CustomItemKotlinListener
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Mob
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import org.bukkit.scheduler.BukkitRunnable

class BurnII() : CustomPotion(
		name = "Burn II",
		customModelData = 820008,
		description = listOf("Fire aura deals damage+", "to enemies within 5 blocks"),
		levelRequirement = 0,
		material = Material.POTION,
		potion = PotionType.FIRE_RESISTANCE
                             ) {

	override fun speciality(player : Player) {
		var countDown = 90
		object : BukkitRunnable() {
			override fun run() {
				if (countDown <= 0) {
					cancel()
				} else {
					countDown -= 1
					for (e in player.location.getNearbyLivingEntities(5.0)) {
						if (e !is Mob) continue
						e.fireTicks = 40
						e.damage(6.0, player)
					}
				}
			}
		}.runTaskTimer(Core.plugin(), 20, 0)
	}

	constructor(quality : Int) : this() {
		this.quality = 0
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}
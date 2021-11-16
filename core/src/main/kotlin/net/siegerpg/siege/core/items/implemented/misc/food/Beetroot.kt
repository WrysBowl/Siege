package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable

class Beetroot() : CustomFood(
	name = "Beetroot",
	customModelData = 330004,
	description = listOf("The fruit can take a beating"),
	levelRequirement = 0,
	material = Material.BEETROOT,
	health = 20.0
                             ) {

	override fun speciality(player: Player) {
		var countDown = 10
		object : BukkitRunnable() {
			override fun run() {
				if (countDown <= 0) {
					cancel()
				} else {
					countDown -= 1
					CustomItemUtils.addHealth(player, 5.0)
					player.playSound(
						player.location,
						Sound.BLOCK_RESPAWN_ANCHOR_CHARGE,
						0.4.toFloat(),
						0.8.toFloat()
					                )
				}
			}
		}.runTaskTimer(Core.plugin(), 20, 40)
	}

	constructor(quality: Int) : this() {
		this.quality = 80
		this.rarity = Rarity.RARE
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}
package net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic

import net.siegerpg.siege.core.Core
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable

class Spongebob() : Cosmetic(
	name = "Spongebob",
	customModelData = 1,
	description = listOf("Who lives in a pineapple under the sea..."),
	material = Material.SPONGE,
) {
	override fun onCosmeticDamage(e: EntityDamageByEntityEvent) {
		val player = e.entity as Player
		val playerHelmet = player.inventory.helmet ?: return
		playerHelmet.type = Material.WET_SPONGE

		object : BukkitRunnable() {
			override fun run() {
				if (player.inventory.helmet == null || !(e.entity as Player).isOnline) {
					cancel()
				} else if (player.inventory.helmet == playerHelmet) {
					playerHelmet.type = Material.SPONGE
					player.inventory.helmet = playerHelmet
				}
			}
		}.runTaskLater(Core.plugin(), 40);
	}

	constructor(quality: Int) : this() {
		this.quality = 90
		this.rarity = Rarity.EPIC
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
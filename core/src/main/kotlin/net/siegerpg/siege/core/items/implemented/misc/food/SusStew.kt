package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class SusStew() : CustomFood(
	name = "Suspicious Stew",
	customModelData = 330008,
	description = listOf("Looks just like my grandma's goulash!"),
	levelRequirement = 0,
	material = Material.SUSPICIOUS_STEW,
	health = 125.0,
                            ) {

	override fun speciality(player: Player) {
		val realPotion = PotionEffect(PotionEffectType.CONFUSION, 200, 9)
		player.addPotionEffect(realPotion)
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
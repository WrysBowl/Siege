package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class Beef() : CustomFood(
		name = "Beef",
		customModelData = 330007,
		description = listOf("Tastes better than raw pork..."),
		levelRequirement = 0,
		material = Material.BEEF,
		health = 80.0,
		quality = 50
                         ) {

	override fun speciality(player : Player) {
		val realPotion = PotionEffect(PotionEffectType.SATURATION, 200, 1)
		player.addPotionEffect(realPotion)
	}

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class BeetrootCurry() : CustomFood(
		name = "Beetroot Curry",
		customModelData = 330014,
		description = listOf("Finally some good food!"),
		levelRequirement = 0,
		material = Material.BEETROOT_SOUP,
		health = 250.0,
		quality = 80
                                  ) {

	override fun speciality(player : Player) {
		val realPotion = PotionEffect(PotionEffectType.REGENERATION, 200, 1)
		player.addPotionEffect(realPotion)
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
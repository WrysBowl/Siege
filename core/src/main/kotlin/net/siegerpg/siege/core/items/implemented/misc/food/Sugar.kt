package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class Sugar() : CustomFood(
	name = "Sugar",
	customModelData = 330002,
	description = listOf("Gas GAS GASSS!!!", "Speed 3 for 30 seconds"),
	levelRequirement = 0,
	material = Material.TROPICAL_FISH,
                          ) {

	override fun speciality(player: Player) {
		val realPotion = PotionEffect(PotionEffectType.SPEED, 600, 2)
		player.addPotionEffect(realPotion)
	}

	constructor(quality: Int) : this() {
		this.quality = 100
		this.rarity = Rarity.LEGENDARY
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}
package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CookedChicken() : CustomFood(
		name = "Drumstick",
		customModelData = 1,
		description = listOf("Siege actual fried chicken"),
		levelRequirement = 0,
		material = Material.COOKED_CHICKEN,
		health = 60.0,
                                  ) {

	constructor(quality : Int) : this() {
		this.quality = 70
		this.rarity = Rarity.RARE
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}
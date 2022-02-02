package net.siegerpg.siege.core.items.implemented.armor.chestplate.ironChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyIronChestplate() : CustomChestplate(
		name = "Healthy Iron Chestplate",
		customModelData = 1,
		description = listOf("Bullet proof"),
		levelRequirement = 50,
		material = Material.IRON_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 56.0, defense = 34.0),
                                                ) {

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
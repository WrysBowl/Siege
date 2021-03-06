package net.siegerpg.siege.core.items.implemented.armor.chestplate.ironChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingIronChestplate() : CustomChestplate(
		name = "Healing Iron Chestplate",
		customModelData = 1,
		description = listOf("Bullet proof"),
		levelRequirement = 35,
		material = Material.IRON_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 20.0, defense = 24.0, regeneration = 57.0),
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
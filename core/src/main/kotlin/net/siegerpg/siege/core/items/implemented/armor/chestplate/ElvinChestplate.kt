package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ElvinChestplate() : CustomChestplate(
	name = "Elvin Chestplate",
	customModelData = 1,
	description = listOf("Beat the evil away!"),
	levelRequirement = 45,
	material = Material.CHAINMAIL_CHESTPLATE,
	baseStats = CustomItemUtils.statMap(
		health = 70.0,
		luck = 60.0,
		toughness = -200.0,
		strength = -25.0
	                                   ),
                                          ) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
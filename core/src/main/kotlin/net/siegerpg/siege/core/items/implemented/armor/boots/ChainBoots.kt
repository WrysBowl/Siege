package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ChainBoots() : CustomBoots(
		name = "Chain Boots",
		customModelData = 1,
		description = listOf("Not the best foot wear"),
		levelRequirement = 40,
		material = Material.CHAINMAIL_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 40.0, defense = 15.0, strength = 20.0),
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
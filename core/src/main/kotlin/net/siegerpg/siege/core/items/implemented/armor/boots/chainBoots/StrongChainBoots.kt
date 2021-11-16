package net.siegerpg.siege.core.items.implemented.armor.boots.chainBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongChainBoots() : CustomBoots(
		name = "Strong Chain Boots",
		customModelData = 1,
		description = listOf("Not the best foot wear"),
		levelRequirement = 29,
		material = Material.CHAINMAIL_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 30.0, strength = 6.0),
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
package net.siegerpg.siege.core.items.implemented.armor.boots.hardenedLeatherBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongHardenedLeatherBoots() : CustomBoots(
		name = "Strong Hardened Leather Boots",
		customModelData = 1,
		description = listOf("Bootleg spurs!"),
		levelRequirement = 17,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 10.0, defense = 8.0, strength = 28.0),
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
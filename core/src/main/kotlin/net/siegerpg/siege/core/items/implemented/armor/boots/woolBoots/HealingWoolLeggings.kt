package net.siegerpg.siege.core.items.implemented.armor.boots.woolBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingWoolBoots() : CustomBoots(
	name = "Healing Wool Boots",
	customModelData = 1,
	description = listOf("Moccasins?"),
	levelRequirement = 8,
	material = Material.LEATHER_BOOTS,
	baseStats = CustomItemUtils.statMap(health = 6.0, regeneration = 3.0),
	leatherColor = Color.WHITE
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
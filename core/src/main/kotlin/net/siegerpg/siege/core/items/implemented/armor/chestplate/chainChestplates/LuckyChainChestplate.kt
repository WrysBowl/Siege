package net.siegerpg.siege.core.items.implemented.armor.chestplate.chainChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyChainChestplate() : CustomChestplate(
		name = "Lucky Chain Chestplate",
		customModelData = 1,
		description = listOf("Cut resistant"),
		levelRequirement = 30,
		material = Material.CHAINMAIL_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 34.0, luck = 46.0),
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
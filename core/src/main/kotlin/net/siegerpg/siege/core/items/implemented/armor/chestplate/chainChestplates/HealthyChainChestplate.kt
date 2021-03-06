package net.siegerpg.siege.core.items.implemented.armor.chestplate.chainChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyChainChestplate() : CustomChestplate(
		name = "Healthy Chain Chestplate",
		customModelData = 1,
		description = listOf("Cut resistant"),
		levelRequirement = 30,
		material = Material.CHAINMAIL_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 48.0, defense = 25.0, regeneration = 10.0),
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
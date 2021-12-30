package net.siegerpg.siege.core.items.implemented.armor.leggings.chainLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughChainLeggings() : CustomLeggings(
		name = "Tough Chain Leggings",
		customModelData = 1,
		description = listOf("Flimsy legs"),
		levelRequirement = 30,
		material = Material.CHAINMAIL_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 35.0, defense = 48.0, regeneration = 2.0),
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
package net.siegerpg.siege.core.items.implemented.armor.leggings.ironleggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingIronLeggings() : CustomLeggings(
		name = "Healing Iron Leggings",
		customModelData = 1,
		description = listOf("Iron jenkins"),
		levelRequirement = 35,
		material = Material.IRON_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 10.0, defense = 40.0, regeneration = 59.0),
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
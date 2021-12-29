package net.siegerpg.siege.core.items.implemented.armor.leggings.ironleggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyIronLeggings() : CustomLeggings(
		name = "Lucky Iron Leggings",
		customModelData = 1,
		description = listOf("Iron jenkins"),
		levelRequirement = 35,
		material = Material.IRON_LEGGINGS,
		baseStats = CustomItemUtils.statMap(
				health = 20.0,
				defense = 50.0,
				regeneration = 10.0,
				luck = 12.0
		                                   ),
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
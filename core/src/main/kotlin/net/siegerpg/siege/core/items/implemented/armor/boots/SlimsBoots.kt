package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SlimsBoots() : CustomBoots(
		name = "Slim's Boots",
		customModelData = 1,
		description = listOf("The Slime Spirit is the first guardian"),
		levelRequirement = 7,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 8.0, strength = 10.0, luck = 12.0),
		leatherColor = Color.LIME,
		gearSetInfo = listOf(listOf("Double jump to jump forwards"))
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
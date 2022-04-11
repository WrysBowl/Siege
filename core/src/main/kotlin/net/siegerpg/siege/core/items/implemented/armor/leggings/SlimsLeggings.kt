package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SlimsLeggings() : CustomLeggings(
		name = "Slim's Leggings",
		customModelData = 1,
		description = listOf("The Slime Spirit is the first guardian"),
		levelRequirement = 7,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 15.0, defense = -15.0, strength = 10.0, luck = 20.0),
		leatherColor = Color.LIME,
		gearSetInfo = listOf("Double jump to jump forwards")
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
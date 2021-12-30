package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TwilightStreamLiners() : CustomBoots(
		name = "Twilight Stream Liners",
		customModelData = 1,
		description = listOf("Evade attacks quickly", "in these trekkers"),
		levelRequirement = 59,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(
				health = 62.0,
				strength = 70.0,
				luck = 35.0,
				regeneration = 40.0,
				defense = -80.0
		                                   ),
		leatherColor = Color.PURPLE
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
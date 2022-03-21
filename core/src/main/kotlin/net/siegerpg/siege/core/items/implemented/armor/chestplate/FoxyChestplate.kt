package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FoxyChestplate() : CustomChestplate(
	name = "Foxy's Chestplate",
	customModelData = 1,
	description = listOf("The Fox Spirit is the seventh guardian"),
	levelRequirement = 44,
	material = Material.CHAINMAIL_CHESTPLATE,
	baseStats = CustomItemUtils.statMap(health = 180.0, defense = 60.0, regeneration = -40.0),
	gearSetInfo = listOf(listOf("Sneak to set a snare trap")),
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
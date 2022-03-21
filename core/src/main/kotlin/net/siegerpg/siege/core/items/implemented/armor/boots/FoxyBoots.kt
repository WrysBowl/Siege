package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FoxyBoots() : CustomBoots(
	name = "Foxy's Boots",
	customModelData = 1,
	description = listOf("The Fox Spirit is the seventh guardian"),
	levelRequirement = 44,
	material = Material.CHAINMAIL_BOOTS,
	baseStats = CustomItemUtils.statMap(health = 150.0, defense = 50.0, luck = -10.0, strength = 25.0, regeneration = -15.0),
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
package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FoxyHelmet() : CustomHelmet(
		name = "Foxy's Helmet",
		customModelData = 1,
		description = listOf("The Fox Spirit is the seventh guardian"),
		levelRequirement = 44,
		material = Material.CHAINMAIL_HELMET,
		baseStats = CustomItemUtils.statMap(health = 160.0, defense = 50.0, strength = 30.0, luck = -40.0),
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
package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class NecromancerFootpads() : CustomBoots(
	name = "Necromancer's Footpads",
	customModelData = 1,
	description = listOf("The Necromancer is the sixth guardian"),
	levelRequirement = 38,
	material = Material.LEATHER_BOOTS,
	baseStats = CustomItemUtils.statMap(health = 150.0, regeneration = 10.0, luck = 20.0),
	gearSetInfo = listOf("Life steal and speed"),
	leatherColor = Color.BLACK
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
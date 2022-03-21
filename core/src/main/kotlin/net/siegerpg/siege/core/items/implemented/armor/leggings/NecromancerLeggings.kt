package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class NecromancerLeggings() : CustomLeggings(
	name = "Necromancer's Leggings",
	customModelData = 1,
	description = listOf("The Necromancer is the sixth guardian"),
	levelRequirement = 38,
	material = Material.LEATHER_LEGGINGS,
	baseStats = CustomItemUtils.statMap(health = 160.0, strength = 45.0, luck = -25.0),
	gearSetInfo = listOf(listOf("Life steal and speed")),
	leatherColor = Color.fromRGB(125, 25, 25)
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
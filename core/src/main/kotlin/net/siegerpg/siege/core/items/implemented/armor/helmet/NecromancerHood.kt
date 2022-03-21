package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class NecromancerHood() : CustomHelmet(
		name = "Necromancer's Hood",
		customModelData = 1,
		description = listOf("The Necromancer is the sixth guardian"),
		levelRequirement = 38,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 140.0, strength = 25.0, regeneration = 35.0, luck = -20.0),
		gearSetInfo = listOf(listOf("Life steal and speed")),
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
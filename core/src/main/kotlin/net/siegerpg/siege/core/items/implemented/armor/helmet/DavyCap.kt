package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class DavyCap() : CustomHelmet(
		name = "Davy's Cap",
		customModelData = 1,
		description = listOf("Davy Jones is the fifth guardian"),
		levelRequirement = 33,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 100.0, strength = 30.0, regeneration = 20.0),
		gearSetInfo = listOf(listOf("Dolphin's Grace II, Speed I, Water breathing II")),
		leatherColor = Color.fromRGB(74, 104, 150)
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
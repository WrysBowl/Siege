package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class EssenceOfTwilight() : CustomHelmet(
		name = "Essence Of Twilight",
		customModelData = 1,
		description = listOf("A well fought battle", "requires a clear mind"),
		levelRequirement = 59,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(
				health = 60.0,
				regeneration = 20.0,
				luck = 60.0,
				strength = -20.0,
				toughness = -80.0
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
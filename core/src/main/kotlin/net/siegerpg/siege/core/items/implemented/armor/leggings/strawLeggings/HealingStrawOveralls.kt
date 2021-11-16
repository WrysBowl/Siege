package net.siegerpg.siege.core.items.implemented.armor.leggings.strawLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingStrawOveralls() : CustomLeggings(
		name = "Healing Straw Overalls",
		customModelData = 1,
		description = listOf("The Last Straw"),
		levelRequirement = 4,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 5.0, regeneration = 6.0),
		leatherColor = Color.YELLOW
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
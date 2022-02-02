package net.siegerpg.siege.core.items.implemented.armor.chestplate.strawChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingStrawChestplate() : CustomChestplate(
		name = "Healing Straw Chestplate",
		customModelData = 1,
		description = listOf("Scarecrow..."),
		levelRequirement = 3,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 6.0, regeneration = 10.0),
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
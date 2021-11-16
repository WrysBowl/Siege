package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GuardianOfTwilight() : CustomChestplate(
		name = "Guardian Of Twilight",
		customModelData = 1,
		description = listOf("Protector of the", "Twilight Forests"),
		levelRequirement = 60,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(
				health = 125.0,
				toughness = 400.0,
				regeneration = 20.0,
				strength = -50.0,
				luck = -60.0
		                                   ),
		leatherColor = Color.SILVER
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
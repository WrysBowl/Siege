package net.siegerpg.siege.core.items.implemented.armor.chestplate.hardenedLeatherChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughHardenedLeatherChestplate() : CustomChestplate(
		name = "Tough Hardened Leather Chestplate",
		customModelData = 1,
		description = listOf("Skin tight. Literally."),
		levelRequirement = 24,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 5.0, defense = 40.0),
		gearSetInfo = listOf(listOf("Deal more knock back"))) {

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
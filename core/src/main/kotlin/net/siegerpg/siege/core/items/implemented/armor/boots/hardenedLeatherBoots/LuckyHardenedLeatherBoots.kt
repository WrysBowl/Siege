package net.siegerpg.siege.core.items.implemented.armor.boots.hardenedLeatherBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyHardenedLeatherBoots() : CustomBoots(
		name = "Lucky Hardened Leather Boots",
		customModelData = 1,
		description = listOf("Bootleg spurs!"),
		levelRequirement = 24,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 10.0, luck = 32.0),
		gearSetInfo = listOf(listOf("Deal more knock back"))
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
package net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod

import net.siegerpg.siege.core.fishing.droptables.RefinedFishTable
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomRod
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class RefinedRod() : CustomRod(
	name = "Refined Rod",
	customModelData = 440005,
	description = listOf("Shiny iron!"),
	levelRequirement = 23,
	material = Material.FISHING_ROD,
	baseStats = CustomItemUtils.statMap(),
	enchantments = hashMapOf(
		Enchantment.LURE to 2,
	),
	fishDropTable = RefinedFishTable()
) {

	constructor(quality: Int) : this() {
		this.quality = 70
		this.rarity = Rarity.RARE
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
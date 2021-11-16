package net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod

import net.siegerpg.siege.core.fishing.droptables.OakFishTable
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomRod
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class OakRod() : CustomRod(
	name = "Oak Rod",
	customModelData = 440002,
	description = listOf("Stronger wood", "less breakable"),
	levelRequirement = 10,
	material = Material.FISHING_ROD,
	baseStats = CustomItemUtils.statMap(),
	enchantments = hashMapOf(
		Enchantment.LURE to 1
	                        ),
	fishDropTable = OakFishTable()
                          ) {

	constructor(quality: Int) : this() {
		this.quality = 0
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
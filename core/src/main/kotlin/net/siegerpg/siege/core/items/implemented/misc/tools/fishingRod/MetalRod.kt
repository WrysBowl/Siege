package net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod

import net.siegerpg.siege.core.fishing.droptables.MetalFishTable
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomRod
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class MetalRod() : CustomRod(
		name = "Metal Rod",
		customModelData = 440004,
		description = listOf("Made of scrap metal"),
		levelRequirement = 18,
		material = Material.FISHING_ROD,
		baseStats = CustomItemUtils.statMap(),
		enchantments = hashMapOf(
				Enchantment.LURE to 2,
		                        ),
		fishDropTable = MetalFishTable()
                            ) {

	constructor(quality : Int) : this() {
		this.quality = 50
		this.rarity = Rarity.UNCOMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
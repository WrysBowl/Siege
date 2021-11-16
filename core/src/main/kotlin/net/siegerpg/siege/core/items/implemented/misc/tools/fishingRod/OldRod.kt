package net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod

import net.siegerpg.siege.core.fishing.droptables.OldFishTable
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomRod
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class OldRod() : CustomRod(
		name = "Old Rod",
		customModelData = 440001,
		description = listOf("Everyone starts somewhere"),
		levelRequirement = 6,
		material = Material.FISHING_ROD,
		baseStats = CustomItemUtils.statMap(),
		enchantments = hashMapOf(
		                        ),
		fishDropTable = OldFishTable()
                          ) {

	constructor(quality : Int) : this() {
		this.quality = 0
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
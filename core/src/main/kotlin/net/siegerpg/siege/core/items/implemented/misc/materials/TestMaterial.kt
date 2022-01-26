package net.siegerpg.siege.core.items.implemented.misc.materials

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestMaterial() : CustomMaterial(
		name = "Iron Material",
		customModelData = 1,
		description = listOf("A material for testing"),
		levelRequirement = 0,
		material = Material.IRON_INGOT
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
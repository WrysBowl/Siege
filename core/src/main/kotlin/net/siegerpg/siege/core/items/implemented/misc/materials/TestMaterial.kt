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
		material = Material.IRON_INGOT,
		upgradeStats = hashMapOf(
				1 to CustomItemUtils.statMap(strength = 1.0),
				2 to CustomItemUtils.statMap(strength = 2.0),
				3 to CustomItemUtils.statMap(strength = 3.0),
				4 to CustomItemUtils.statMap(strength = 4.0),
				5 to CustomItemUtils.statMap(strength = 5.0)
		                        )
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

	companion object {

		fun tier(tier : Int) : TestMaterial {
			val newItem = TestMaterial(0)
			newItem.tier = tier
			return newItem
		}
	}

}
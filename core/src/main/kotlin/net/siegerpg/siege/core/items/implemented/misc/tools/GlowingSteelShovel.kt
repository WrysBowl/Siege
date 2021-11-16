package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class GlowingSteelShovel() : CustomTool(
		name = "Glowing Steel Shovel",
		customModelData = 420012,
		description = listOf("Enchanted steel"),
		levelRequirement = 41,
		material = Material.IRON_SHOVEL,
		baseStats = CustomItemUtils.statMap(luck = 10.0),

		enchantments = hashMapOf(
				Enchantment.DIG_SPEED to 2
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

}
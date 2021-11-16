package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class GlowingWoodenPickaxe() : CustomTool(
		name = "Glowing Wooden Pickaxe",
		customModelData = 410002,
		description = listOf("Enchanted!"),
		levelRequirement = 5,
		material = Material.WOODEN_PICKAXE,
		baseStats = CustomItemUtils.statMap(),

		enchantments = hashMapOf(
				Enchantment.DIG_SPEED to 1
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
package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BonePickaxe() : CustomTool(
		name = "Bone Pickaxe",
		customModelData = 410003,
		description = listOf("Caveman tools"),
		levelRequirement = 8,
		material = Material.WOODEN_PICKAXE,
		baseStats = CustomItemUtils.statMap(luck = 10.0),

		enchantments = hashMapOf(
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
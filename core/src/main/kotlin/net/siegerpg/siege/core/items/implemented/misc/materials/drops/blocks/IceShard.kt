package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IceShard() : CustomMaterial(
	name = "Ice Shard",
	customModelData = 320015,
	description = listOf("An ice shard", "from snowy peaks"),
	levelRequirement = 0,
	material = Material.FLINT,

	) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

	companion object {
		fun tier(tier: Int): IceShard {
			val newItem = IceShard(0)
			newItem.tier = tier
			return newItem
		}
	}

}
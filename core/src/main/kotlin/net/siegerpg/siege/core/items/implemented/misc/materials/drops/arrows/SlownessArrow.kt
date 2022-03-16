package net.siegerpg.siege.core.items.implemented.misc.materials.drops.arrows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomArrow
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionType

class SlownessArrow() : CustomArrow(
		name = "Slowness Arrow",
		customModelData = 1,
		description = listOf("Slow your target"),
		levelRequirement = 0,
		material = Material.TIPPED_ARROW,
		potion = PotionType.SLOWNESS
                                   ) {
	override fun getSellValue() : Int {
		return 10
	}
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
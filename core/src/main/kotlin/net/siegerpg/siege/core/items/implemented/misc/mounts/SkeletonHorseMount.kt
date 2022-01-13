package net.siegerpg.siege.core.items.implemented.misc.mounts

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMount
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SkeletonHorseMount() : CustomMount(
		name = "Skeleton Horse Mount",
		customModelData = 330010,
		description = listOf("Spooky scary skeleton"),
		material = Material.SKELETON_HORSE_SPAWN_EGG,
                                        ) {

	constructor(quality : Int) : this() {
		this.quality = 70
		this.rarity = Rarity.RARE
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
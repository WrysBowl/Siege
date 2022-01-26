package net.siegerpg.siege.core.items.implemented.misc.mounts

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMount
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MooshroomMount() : CustomMount(
		name = "Mooshroom Mount",
		customModelData = 330007,
		description = listOf("Infected cow"),
		material = Material.MOOSHROOM_SPAWN_EGG,
		quality = 50
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
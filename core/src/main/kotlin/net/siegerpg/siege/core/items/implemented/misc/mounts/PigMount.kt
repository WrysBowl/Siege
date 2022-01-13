package net.siegerpg.siege.core.items.implemented.misc.mounts

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMount
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PigMount() : CustomMount(
		name = "Pig Mount",
		customModelData = 330001,
		description = listOf("A tamed pig"),
		material = Material.PIG_SPAWN_EGG,
                              ) {

	constructor(quality : Int) : this() {
		this.quality = 30
		this.rarity = Rarity.COMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
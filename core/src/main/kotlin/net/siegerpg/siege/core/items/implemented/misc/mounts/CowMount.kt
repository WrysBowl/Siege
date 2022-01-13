package net.siegerpg.siege.core.items.implemented.misc.mounts

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMount
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CowMount() : CustomMount(
		name = "Cow Mount",
		customModelData = 330003,
		description = listOf("A tamed cow"),
		material = Material.COW_SPAWN_EGG,
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
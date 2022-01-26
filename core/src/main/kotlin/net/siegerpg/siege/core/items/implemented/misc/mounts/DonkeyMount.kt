package net.siegerpg.siege.core.items.implemented.misc.mounts

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMount
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class DonkeyMount() : CustomMount(
		name = "Donkey Mount",
		customModelData = 330005,
		description = listOf("A trusty donkey"),
		material = Material.DONKEY_SPAWN_EGG,
		quality = 70
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
package net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SlimeSpiritKey() : CustomKey(
		name = "Slime Spirit Key",
		customModelData = 620002,
		description = listOf("Used to summon", "the Slime spirit"),
		material = Material.TRIPWIRE_HOOK,
		quality = 0
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
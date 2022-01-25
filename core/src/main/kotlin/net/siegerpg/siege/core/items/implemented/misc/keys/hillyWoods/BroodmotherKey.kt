package net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BroodmotherKey() : CustomKey(
		name = "Broodmother Key",
		customModelData = 620010,
		description = listOf("Used to summon", "the Broodmother"),
		material = Material.TRIPWIRE_HOOK,
		quality = 100,
		sellCost = 15000
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
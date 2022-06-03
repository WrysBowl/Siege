package net.siegerpg.siege.core.items.implemented.misc.keys.crate

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MobKey() : CustomKey(
		name = "Mob Key",
		customModelData = 640001,
		description = listOf("Drops a random mob's loot table"),
		material = Material.TRIPWIRE_HOOK,
		quality = 70
                          ) {
	override fun getSellValue() : Int {
		return 200
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
package net.siegerpg.siege.core.items.implemented.weapons.ranged.Tridents

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyTrident() : CustomBow(
		name = "Lucky Trident",
		customModelData = 0,
		description = listOf("Poseidon's fork"),
		levelRequirement = 34,
		material = Material.TRIDENT,
		baseStats = CustomItemUtils.statMap(strength = 30.0, luck = 28.0),

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
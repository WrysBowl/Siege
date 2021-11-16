package net.siegerpg.siege.core.items.implemented.weapons.ranged.ironBows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyIronBow() : CustomBow(
	name = "Healthy Iron Bow",
	customModelData = 120008,
	description = listOf("Heavy and durable"),
	levelRequirement = 34,
	material = Material.BOW,
	baseStats = CustomItemUtils.statMap(strength = 30.0, luck = 12.0, health = 20.0),
                                  ) {

	constructor(quality: Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item: ItemStack) : this() {
		this.item = item
		deserialize()
	}

}
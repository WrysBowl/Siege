package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SporeShot() : CustomBow(
	name = "Spore Shot",
	customModelData = 120013,
	description = listOf("Shoot mushrooms", "at your foes"),
	levelRequirement = 53,
	material = Material.BOW,
	baseStats = CustomItemUtils.statMap(
		strength = 85.0,
		luck = 50.0,
		regeneration = -50.0,
		toughness = -200.0
	)
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
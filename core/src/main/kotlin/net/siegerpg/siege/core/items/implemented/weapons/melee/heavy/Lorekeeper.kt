package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Lorekeeper() : CustomMeleeWeapon(
		name = "Lorekeeper",
		customModelData = 130013,
		description = listOf("Knowledge is the", "strongest weapon"),
		levelRequirement = 60,
		material = Material.WOODEN_AXE,
		baseStats = CustomItemUtils.statMap(
				strength = 175.0,
				luck = 25.0,
				defense = -150.0,
				health = -60.0
		                                   ),
		attackSpeed = 0.6
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
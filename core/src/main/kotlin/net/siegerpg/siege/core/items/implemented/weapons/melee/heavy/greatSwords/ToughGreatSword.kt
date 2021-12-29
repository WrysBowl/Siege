package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughGreatSword() : CustomMeleeWeapon(
		name = "Tough Great Sword",
		customModelData = 130006,
		description = listOf("A typical medieval weapon"),
		levelRequirement = 23,
		material = Material.WOODEN_AXE,
		baseStats = CustomItemUtils.statMap(strength = 30.0, defense = 50.0),
		attackSpeed = 0.9
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
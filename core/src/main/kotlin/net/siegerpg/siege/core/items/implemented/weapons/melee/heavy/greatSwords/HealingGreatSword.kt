package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingGreatSword() : CustomMeleeWeapon(
		name = "Healing Great Sword",
		customModelData = 130006,
		description = listOf("A typical medieval weapon"),
		levelRequirement = 29,
		material = Material.WOODEN_AXE,
		baseStats = CustomItemUtils.statMap(strength = 32.0, regeneration = 5.0),
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
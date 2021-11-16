package net.siegerpg.siege.core.items.implemented.weapons.melee.light.spades

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckySpade() : CustomMeleeWeapon(
	name = "Lucky Spade",
	customModelData = 110003,
	description = listOf("Not a shovel"),
	levelRequirement = 9,
	material = Material.WOODEN_SWORD,
	baseStats = CustomItemUtils.statMap(strength = 8.0, luck = 5.0),
	attackSpeed = 1.5
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
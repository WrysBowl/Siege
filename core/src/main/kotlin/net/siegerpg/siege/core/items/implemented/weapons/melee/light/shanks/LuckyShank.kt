package net.siegerpg.siege.core.items.implemented.weapons.melee.light.shanks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyShank() : CustomMeleeWeapon(
		name = "Lucky Shank",
		customModelData = 110005,
		description = listOf("An essential tool...in prison"),
		levelRequirement = 21,
		material = Material.WOODEN_SWORD,
		baseStats = CustomItemUtils.statMap(strength = 14.0, luck = 5.0),

		attackSpeed = 1.7
                                      ) {

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		this.deserialize()
	}

}
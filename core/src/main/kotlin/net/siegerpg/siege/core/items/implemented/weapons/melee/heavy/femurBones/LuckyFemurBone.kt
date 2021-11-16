package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.femurBones

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyFemurBone() : CustomMeleeWeapon(
	name = "Lucky Femur Bone",
	customModelData = 130003,
	description = listOf("A large animal's femur"),
	levelRequirement = 11,
	material = Material.WOODEN_AXE,
	baseStats = CustomItemUtils.statMap(strength = 18.0, luck = 5.0),
	attackSpeed = 0.9
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
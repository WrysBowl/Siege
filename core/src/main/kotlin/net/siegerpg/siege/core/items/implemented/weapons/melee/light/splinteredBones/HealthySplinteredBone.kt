package net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthySplinteredBone() : CustomMeleeWeapon(
	name = "Healthy Splintered Bone",
	customModelData = 110009,
	description = listOf("The shard of a", "human femur bone"),
	levelRequirement = 34,
	material = Material.WOODEN_SWORD,
	baseStats = CustomItemUtils.statMap(strength = 32.0, health = 10.0),
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
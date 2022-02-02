package net.siegerpg.siege.core.items.implemented.weapons.melee.light.splinteredBones

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckySplinteredBone() : CustomMeleeWeapon(
		name = "Lucky Splintered Bone",
		customModelData = 110009,
		description = listOf("The shard of a", "human femur bone"),
		levelRequirement = 48,
		material = Material.WOODEN_SWORD,
		baseStats = CustomItemUtils.statMap(strength = 32.0, luck = 6.0),
		attackSpeed = 1.5
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
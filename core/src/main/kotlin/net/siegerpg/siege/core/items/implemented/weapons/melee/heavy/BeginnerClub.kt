package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BeginnerClub() : CustomMeleeWeapon(
	name = "Beginner Club",
	customModelData = 130001,
	description = listOf("Try out this heavy melee weapon!"),
	levelRequirement = 0,
	material = Material.WOODEN_AXE,
	baseStats = CustomItemUtils.statMap(strength = 7.0),
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
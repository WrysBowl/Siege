package net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughStickyStick() : CustomMeleeWeapon(
		name = "Tough Sticky Stick",
		customModelData = 110002,
		description = listOf("Globs of slime on a stick"),
		levelRequirement = 5,
		material = Material.WOODEN_SWORD,
		baseStats = CustomItemUtils.statMap(strength = 4.0, defense = 20.0),
		attackSpeed = 1.6
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
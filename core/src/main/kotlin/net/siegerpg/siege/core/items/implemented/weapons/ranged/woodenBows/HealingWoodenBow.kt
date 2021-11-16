package net.siegerpg.siege.core.items.implemented.weapons.ranged.woodenBows

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingWoodenBow() : CustomBow(
		name = "Healing Wooden Bow",
		customModelData = 0,
		description = listOf("Your standard issue ranged weapon"),
		levelRequirement = 6,
		material = Material.BOW,
		baseStats = CustomItemUtils.statMap(strength = 15.0, regeneration = 3.0),
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
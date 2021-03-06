package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.stoneAxes

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughStoneAxe() : CustomMeleeWeapon(
		name = "Tough Stone Axe",
		customModelData = 130004,
		description = listOf("Commonly used for chopping trees"),
		levelRequirement = 15,
		material = Material.WOODEN_AXE,
		baseStats = CustomItemUtils.statMap(strength = 25.0, defense = 60.0),
		attackSpeed = 0.8
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
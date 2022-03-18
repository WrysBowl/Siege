package net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyMagmaChestplate() : CustomChestplate(
		name = "Lucky Magma Chestplate",
		customModelData = 1,
		description = listOf("This really warms my heart"),
		levelRequirement = 17,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 20.0, defense = 10.0, luck = 15.0),
		leatherColor = Color.ORANGE,
		gearSetInfo = listOf(listOf("Have a 30% chance to burn attackers"))
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
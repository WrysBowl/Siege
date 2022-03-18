package net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyMagmaBoots() : CustomBoots(
		name = "Lucky Magma Boots",
		customModelData = 1,
		description = listOf("Some lit boots"),
		levelRequirement = 17,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 15.0, luck = 19.0),
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
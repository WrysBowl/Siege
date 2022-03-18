package net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckySlimyLeggings() : CustomLeggings(
		name = "Lucky Slimy Leggings",
		customModelData = 1,
		description = listOf("Waste high in sewage"),
		levelRequirement = 7,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 6.0, defense = 6.0, luck = 15.0),
		leatherColor = Color.LIME,
		gearSetInfo = listOf(listOf("Jump high like a slime!"))
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
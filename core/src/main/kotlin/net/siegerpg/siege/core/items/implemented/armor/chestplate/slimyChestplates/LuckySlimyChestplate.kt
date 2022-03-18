package net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckySlimyChestplate() : CustomChestplate(
		name = "Lucky Slimy Chestplate",
		customModelData = 1,
		description = listOf("Jelly belly"),
		levelRequirement = 7,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 8.0, defense = 8.0, luck = 15.0),
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
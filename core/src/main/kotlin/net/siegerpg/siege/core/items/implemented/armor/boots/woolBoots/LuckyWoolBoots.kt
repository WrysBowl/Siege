package net.siegerpg.siege.core.items.implemented.armor.boots.woolBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyWoolBoots() : CustomBoots(
		name = "Lucky Wool Boots",
		customModelData = 1,
		description = listOf("Moccasins?"),
		levelRequirement = 11,
		material = Material.LEATHER_BOOTS,
		baseStats = CustomItemUtils.statMap(health = 6.0, luck = 17.0),
		leatherColor = Color.WHITE
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
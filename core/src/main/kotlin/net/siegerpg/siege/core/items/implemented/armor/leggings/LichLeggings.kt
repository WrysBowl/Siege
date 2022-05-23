package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LichLeggings() : CustomLeggings(
		name = "Lich's Leggings",
		customModelData = 1,
		description = listOf("The Lich is the fourth guardian"),
		levelRequirement = 28,
		material = Material.LEATHER_LEGGINGS,
		baseStats = CustomItemUtils.statMap(health = 100.0, defense = 40.0, strength = 15.0, luck = -15.0),
		leatherColor = Color.fromRGB(70, 70, 70),
		gearSetInfo = listOf("Sneak to teleport to nearest mob and back")
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
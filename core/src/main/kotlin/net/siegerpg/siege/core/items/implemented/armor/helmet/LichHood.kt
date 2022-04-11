package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LichHood() : CustomHelmet(
		name = "Lich's Hood",
		customModelData = 1,
		description = listOf("The Lich is the fourth guardian"),
		levelRequirement = 28,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 75.0, defense = 40.0, luck = 35.0, regeneration = -20.0),
		gearSetInfo = listOf("Sneak to teleport to nearest mob and back"),
		leatherColor = Color.fromRGB(70, 70, 70)
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
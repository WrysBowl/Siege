package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LichCloak() : CustomChestplate(
		name = "Lich's Cloak",
		customModelData = 1,
		description = listOf("The Lich is the fourth guardian"),
		levelRequirement = 28,
		material = Material.CHAINMAIL_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 120.0, defense = 50.0, luck = -10.0),
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